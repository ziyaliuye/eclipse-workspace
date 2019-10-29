package cn.cnm.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.cnm.entity.Dept;

// 只需要在接口类注解 @FeignClient 就能使用这个微服务进行面向接口编程 
// value就是服务名
// fallbackFactory 属性表示这个接口下所有类出异常后都会调用指定的方法
@FeignClient(value = "provider", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClentService {
	@RequestMapping(value = "/dept/get{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") long id);

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list();

	@RequestMapping(value = "/dept/add", method = RequestMethod.GET)
	public boolean add(Dept dept);
}
