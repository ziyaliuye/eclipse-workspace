package cn.cnm.server;

import javax.xml.ws.Endpoint;
import cn.cnm.webservice.impl.HelloWSImpl;

public class ServerTest {
	// 发布WebService
	public static void main(String[] args) {
		// 第一个参数是URL， 端口和服务都是自定义的
		// 第二个参数是服务的实例
		Endpoint.publish("http://127.0.0.1:8098/webservice-server/hellowsimpl", new HelloWSImpl());
	}

}
