package cn.cnm.interceptor;

import java.util.List;
import javax.xml.namespace.QName;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class MyOutServerInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
	// 客户端传过来的用户名和密码
	private String name;
	private String password;

	// 添加一个构造方法，继承这个类就需要强制重写（要告诉拦截器要在什么时候拦截）
	public MyOutServerInterceptor(String name, String password) {
		// PRE_PROTOCOL表示初始化协议时， 调用父类构造器， 表示初始化协议的时候拦截
		super(Phase.PRE_PROTOCOL);
		this.name = name;
		this.password = password;
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		// 传入的对象是一个消息对象， 获取它的头信息准备添加内容
		List<Header> headers = message.getHeaders();
		message.setId("wocaonimei");
		// 创建一个XML的文档对象
		/*
		 * <person> <name>王二狗子</name> <password>123456</password> </penson>
		 */
		Document document = DocumentHelper.createDocument();
		Element rootElement = document.addElement("person");
		Element nameElement = rootElement.addElement("name");
		nameElement.addAttribute("name", name);
		Element passwordElement = rootElement.addElement("password");
		passwordElement.addAttribute("passwrod", password);

		// 第一个参数是唯一标志， 名字还得和rootElement一样， 不然出错
		// 第二个参数就是xml文档
		headers.add(new Header(new QName("person"), document));

		System.out.println(rootElement.toString());

	}
}
