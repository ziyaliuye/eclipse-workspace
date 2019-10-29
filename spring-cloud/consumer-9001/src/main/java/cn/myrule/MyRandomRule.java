package cn.myrule;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

// 和 RandomRule 一样继承 AbstractLoadBalancerRule 接口
public class MyRandomRule extends AbstractLoadBalancerRule {
	private int total = 0; // 总共被调用的次数，目前要求每台被调用5次
	private int currentIndex = 0; // 当前提供服务的机器号

	// 随机策略的逻辑
	public Server choose(ILoadBalancer lb, Object key) {
		if (lb == null) {
			return null;
		}
		Server server = null;
		while (server == null) {
			if (Thread.interrupted()) {
				return null;
			}
			// 获取所有当前能提供服务节点（Live的服务）的集合
			List<Server> upList = lb.getReachableServers();
			// 获取所有当前服务节点的集合
			List<Server> allList = lb.getAllServers();

			int serverCount = allList.size();
			if (serverCount == 0) {
				/*
				 * No servers. End regardless of pass, because subsequent passes only get more
				 * restrictive.
				 */
				return null;
			}
			// int index = chooseRandomInt(serverCount);
			// 这里虽然获取了所有的服务（包括挂掉的服务）， 但取的时候是略过这些挂掉的服务的
			// server = upList.get(index);

			// 自定义策略， 每台机器使用5次后才使用下一台机器
			if (total < 5) {
				server = upList.get(currentIndex);
				total++;
			} else { // 超过5次后当前循环跳出， 下一次调用的时候才会返回服务
				total = 0;
				currentIndex++;
				if (currentIndex >= upList.size()) {
					currentIndex = 0;
				}
			}

			if (server == null) {
				/*
				 * The only time this should happen is if the server list were somehow trimmed.
				 * This is a transient condition. Retry after yielding.
				 */
				Thread.yield();
				continue;
			}
			// 再判断一次服务是否活着
			if (server.isAlive()) {
				return (server);
			}

			// Shouldn't actually happen.. but must be transient or a bug.
			server = null;
			Thread.yield();
		}
		return server;

	}

	// 取下一个随机数， 上面的方法在调用这里
	protected int chooseRandomInt(int serverCount) {
		return ThreadLocalRandom.current().nextInt(serverCount);
	}

	// 单纯的就是调用了上面的 choose 方法
	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	// 空实现， 咱不用例会
	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
	}
}
