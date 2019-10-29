package cn.cnm.interceptor;

import javax.xml.namespace.QName;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.dom4j.Element;

@SuppressWarnings("all")
public class MyServerInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	// 添加一个构造方法，继承这个类就需要强制重写（要告诉拦截器要在什么时候拦截）
	public MyServerInterceptor() {
		// PRE_PROTOCOL表示初始化协议时， 调用父类构造器， 表示初始化协议的时候拦截
		super(Phase.PRE_PROTOCOL);
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		Header header = message.getHeader(new QName("person"));
		if (header != null) {
			Element person = (Element) header.getObject();
			String name = person.getText();
			System.out.println(name);
//			String password = person.getElementsByTagName("password").item(0).getTextContent();
//			if ("王二狗子".equals(name) && "123456".equals(password)) {
//				System.out.println("Server 通过拦截器....");
//				return;
//			}
		}
		System.out.println("Server通过拦截器....");
		// 随便加个判断逻辑
		if (message == null) {
			// 服务端抛出异常， 服务端控制台并不会打印错误日志， 而是在客户端打印
			throw new Fault(new RuntimeException("请求需要一个正确的用户名和密码!"));
		}
	}
}
