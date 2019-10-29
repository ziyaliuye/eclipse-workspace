package cn.cnm.server;

import java.util.List;
import javax.xml.ws.Endpoint;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.message.Message;
import cn.cnm.interceptor.MyServerInterceptor;
import cn.cnm.webservice.impl.HelloWSImpl;

public class CustomInterceptorTest {
	// 发布WebServiceMyServerInterceptor
	public static void main(String[] args) {
		// 第一个参数是URL， 端口和服务都是自定义的
		// 第二个参数是服务的实例
		EndpointImpl endpointImpl = (EndpointImpl) Endpoint
				.publish("http://127.0.0.1:8098/webservice-server/hellowsimpl", new HelloWSImpl());
		// 服务端的入拦截器, 得到的是一个集合（入拦截器集合）
		List<Interceptor<? extends Message>> inInterceptors = endpointImpl.getInInterceptors();
		// 往集合里添加一个日志拦截器
		inInterceptors.add(new LoggingInInterceptor());

		// 服务端的出入拦截器, 得到的是一个集合（出拦截器集合）
		List<Interceptor<? extends Message>> outInterceptors = endpointImpl.getOutInterceptors();
		// 往集合里添加一个日志拦截器
		outInterceptors.add(new MyServerInterceptor());
	}

}
