package cn.cnm.springmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SpringConsumer {
	// 将Spring提供的工具类注入进来
	@Autowired
	private JmsTemplate jsmTemplate;
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		SpringConsumer consumer = applicationContext.getBean("springConsumer", SpringConsumer.class);
		// 接收消息并自动转换
		String message = consumer.jsmTemplate.receiveAndConvert().toString();
		System.out.println("接收到消息：" + message);
	}
}
