package cn.cnm.queue;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsProduceTopic {
	// ActiveMQ使用的是tcp协议（不要与前台访问的弄混了）
	public static final String ACTIVEMQ_URL = "tcp://192.168.58.128:61616";
	// 创建Topic的名称
	public static final String TOPIC_NAME = "topic01";

	public static void main(String[] args) throws JMSException {
		// 创建ActiveMQ连接工厂， 按照给定的URL地址
		// 采用默认用户名和密码（如果有修改，构造参数第一二个参数就是用户名密码）
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
		// 创建一个ActiveMQ的连接对象
		Connection connection = activeMQConnectionFactory.createConnection();
		// 启动访问
		connection.start();
		// 创建Session会话
		// 第一个参数 事务
		// 第二个事务 签收
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 创建目的地（指定是Queue还是Topic）
		// Destination destination = session.createQueue(TOPIC_NAME);
		// Topic是Destination（目的地）的子类， 拥有更多的功能
		Topic topic = session.createTopic(TOPIC_NAME);
		// 创建消息的生产者, 绑定Topic
		MessageProducer messageProducer = session.createProducer(topic);
		messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
		for (int i = 1; i <= 10; i++) {
			// 建立一条文本消息对象
			TextMessage textMessage = session.createTextMessage("Topic" + i);
			// 使用生产者发送指定消息消息到Topic中
			messageProducer.send(textMessage);
			System.out.println("Topic发布完成， 消息内容：" + textMessage.getText());
		}
		// 关闭资源
		messageProducer.close();
		session.close();
		connection.close();
	}

}
