package cn.cnm.service;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.cnm.entity.Dept;
import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClentService> {

	@Override
	public DeptClentService create(Throwable cause) {
		// 返回匿名内部类， 按 a/t + / 能自动导出下面代码
		// 相当于就是将Hystrix熔断器的FallBack都写到了这里
		return new DeptClentService() {

			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Dept get(long id) {
				return new Dept().setDeptno(id).setDname("找不到id：" + id + "对应的信息！")
						.setDb_source("此时服务 Provider 已经关闭！");
			}

			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
