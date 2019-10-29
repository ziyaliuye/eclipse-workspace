package cn.cnm.webservice.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import cn.cnm.webservice.HelloWS;
@WebService
public class HelloWSImpl implements HelloWS {
	@WebMethod
	public String sayHello(String name) {
		System.out.println("server :" + name);
		return "Hello: " + name;
	}
}
