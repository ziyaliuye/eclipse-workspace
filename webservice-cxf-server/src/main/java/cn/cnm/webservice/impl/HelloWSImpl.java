package cn.cnm.webservice.impl;

import cn.cnm.webservice.HelloWS;
public class HelloWSImpl implements HelloWS {
	public String sayHello(String name) {
		System.out.println("server :" + name);
		return "Hello: " + name;
	}
}
