package cn.cnm.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

// 表示这个类是 Spring 的 beans 配置类
@Configuration
public class ConfigBean {
	/*
	 * // SpringBoot 中的写法 public UserService userService{ return new
	 * UserServiceImpl(); }
	 * 
	 * //Spring 的写法 <bean id="userService" class="cn.cnm.UserServiceImpl">
	 * 
	 * ConfigBean(@Configuration) == applicaitonContext.xml
	 */

	/*
	 * @Bean public IRule myRule() { // 返回随机算法类型， 这样显示的声明这个方法， Ribbon就会用它替换默认算法
	 * return new RandomRule(); }
	 */

	@Bean
	@LoadBalanced
	public RestTemplate RestTemplate() {
		return new RestTemplate();
	}
}
