package cn.cnm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.cnm.entity.Dept;
import cn.cnm.service.DeptService;

@RestController
public class DeptController {
	@Autowired
	private DeptService service;

	@RequestMapping(value = "/dept/get{id}", method = RequestMethod.GET)
	// 这个注解表示一旦调用服务抛出异常后会调用 processHstrix_Get 方法
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = this.service.get(id);
		if (dept == null) {
			throw new RuntimeException("没有找到对应的信息！");
		}
		return this.service.get(id);
	}

	public Dept processHystrix_Get(@PathVariable("id") Long id) {
		return new Dept().setDeptno(id).setDname("找不到id：" + id + "对应的信息！")
				.setDb_source("no this database in MYSQL！");
	}

	// Hystrix 熔断机制捕捉异常后调用的方法， 也是向调用方放回一个json串
	// 这个就是介绍说的向调用方返回一个符合预期的， 可处理的备用响应 FallBack
	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return this.service.add(dept);
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> get() {
		return this.service.list();
	}

	// 服务的发现, 它可以从注册中心获取当前所有暴露出来的服务的描述
	// client.getServices() 可以返回一个list集合， 里面就是所有的暴露的服务描述
	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery() {
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("Spring-Cloud-Demo");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}
}
