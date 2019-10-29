package cn.cnm.service;

import cn.cnm.service.DemoService;

public class DemoServiceImpl implements DemoService {
	public String demo(String name) {
		return "RPC：" + name;
	}

}
