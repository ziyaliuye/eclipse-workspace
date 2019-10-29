package cn.cnm.test;

import java.util.List;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.message.Message;

import cn.cnm.webservice.HelloWS;
import cn.cnm.webservice.impl.HelloWSImplService;

public class ClientTest {

	public static void main(String[] args) {
		// 实例化工具类生成的服务工厂类实例
		HelloWSImplService factory = new HelloWSImplService();
		// 接收服务端生成的webservice代理对象
		HelloWS helloWS = factory.getHelloWSImplPort();

		// 通过ClientProxy的静态方法通过“代理对象实例”获取“发送请求的客户端实例”
		Client client = ClientProxy.getClient(helloWS);
		// 从发送客户端的实例中获取出拦截器集合
		List<Interceptor<? extends Message>> outInterceptors = client.getInInterceptors();
		outInterceptors.add(new LoggingInInterceptor());
		// 从发送客户端的实例中获取入出拦截器集合
		List<Interceptor<? extends Message>> inInterceptors = client.getOutInterceptors();
		inInterceptors.add(new LoggingOutInterceptor());

		// 直接调用实例方法
		System.out.println(helloWS.sayHello("wocao"));

	}

}
