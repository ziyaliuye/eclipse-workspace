package cn.cnm.test;

import cn.cnm.webservice.impl.HelloWS;
import cn.cnm.webservice.impl.HelloWSImplService;

public class ClientTest {

	public static void main(String[] args) {
		// 实例化工具类生成的服务工厂类实例
		HelloWSImplService factory = new HelloWSImplService();
		// 接收服务端生成的webservice代理对象
		HelloWS helloWS = factory.getHelloWSImplPort();
		// 直接调用实例方法
		System.out.println(helloWS.sayHello("wocao"));

	}

}
