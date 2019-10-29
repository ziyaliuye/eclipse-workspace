package cn.cnm.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloWS {
	@WebMethod
	String sayHello(String name);
}
