package cn.cnm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.cnm.entity.Dept;

@RestController
public class DeptController {
	// 服务请求地址， 启动负载均衡后不要写死地址， 要用服务名， 服务也有可能是多台机器， 所以最好不要用端口命名
	//private static final String REST_URL_PREFIX = "http://localhost:8001";
	private static final String REST_URL_PREFIX = "http://provider";

	@Autowired
	private RestTemplate restTemplate;

	// url：REST请求地址, 服务的地址：localhost:8001/dept/add
	// requestMap：请求参数
	// ResponseBean.class：HTTP响应返回值被转成成的对象类型
	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, boolean.class);
	}

	// getForObject 方法没有请求参数， 链接中已经包含参数
	@RequestMapping(value = "/consumer/dept/get{id}")
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get" + id, Dept.class);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}

	// 调用 8001服务的 discover 来查看8001的项目描述
	@RequestMapping(value = "/consumer/dept/discovery")
	public Object discovery() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
	}
}
