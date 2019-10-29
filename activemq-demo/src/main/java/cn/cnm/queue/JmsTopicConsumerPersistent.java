package cn.cnm.queue;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsTopicConsumerPersistent {
	// ActiveMQ使用的是tcp协议（不要与前台访问的弄混了）
	public static final String ACTIVEMQ_URL = "tcp://192.168.58.128:61616";
	// 要访问的TOPIC的名称
	public static final String TOPIC_NAME = "topic-persistent";

	public static void main(String[] args) throws JMSException {
		// 创建ActiveMQ连接工厂， 按照给定的URL地址
		// 采用默认用户名和密码（如果有修改，构造参数第一二个参数就是用户名密码）
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
		// 创建一个ActiveMQ的连接对象
		Connection connection = activeMQConnectionFactory.createConnection();
		// 设置订阅者的ID， 好区分谁接收了消息， 在控制台中能清楚看到谁订阅了
		connection.setClientID("first computer...");
		// 创建Session会话
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 创建目的地（指定是Queue还是Topic）
		Topic topic = session.createTopic(TOPIC_NAME);
		// 主题的订阅者(TopicSubscriber)
		// 第一次参数就是消息目的地， 第二个参数是备注， 可以随便写
		TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic, "reamrk...");
		// 启动访问， 注意这里start代码位置和之前的不一样了， 挪到设置持久化之后了
		connection.start();
		// 订阅者接收消息
		Message message = topicSubscriber.receive();
		while (null != message) {
			TextMessage textMessage = (TextMessage) message;
			System.out.println("收到持久化Topic：" + textMessage.getText());
			// 一直接收发布者发布的消息
			message = topicSubscriber.receive(1000);
		}

		// 关闭资源
		session.close();
		connection.close();
	}
}
