package cn.cnm.springmq;

import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SpringProducer {
	// 将Spring提供的工具类注入进来
	@Autowired
	private JmsTemplate jsmTemplate;
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		SpringProducer producer = applicationContext.getBean("springProducer", SpringProducer.class);
		// MessageCreator是Spring提供的一个接口， 用于快速创建一个消息
//		producer.jsmTemplate.send(new MessageCreator() {
//			@Override
//			public Message createMessage(Session arg0) throws JMSException {
//				TextMessage textMessage = arg0.createTextMessage("Spring and ActiveMQ Combination Message..");
//				return textMessage;
//			}
//		});

		// lambda表达式
		producer.jsmTemplate.send((arg0) -> {
			TextMessage textMessage = arg0.createTextMessage("Spring and ActiveMQ Combination Message1..");
			return textMessage;
		});

		System.out.println("消息生产完成...");
	}
}
