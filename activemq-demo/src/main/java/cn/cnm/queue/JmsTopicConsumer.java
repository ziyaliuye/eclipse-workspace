package cn.cnm.queue;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsTopicConsumer {
	// ActiveMQ使用的是tcp协议（不要与前台访问的弄混了）
	public static final String ACTIVEMQ_URL = "tcp://192.168.58.128:61616";
	// 要访问的TOPIC的名称
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

		// 创建消息消费者， 绑定Topic
		MessageConsumer messageConsumer = session.createConsumer(topic);
		// 创建一个死循环, 可以让程序一直等待着
		while (true) {
			// receive 空参数时表示一致等待，知道有消息返回, 也添加参数等待时间 ms
			// 返回的消息有5种， TextMessage是其中一种， 所以需要强转
			TextMessage textMessage = (TextMessage) messageConsumer.receive();
			if (textMessage != null) {
				System.out.println("1号接收者接收到订阅消息：" + textMessage.getText());
			} else {
				break;
			}
		}
		// 关闭资源， 上面是死循环的时候这里是不会执行的
		messageConsumer.close();
		session.close();
		connection.close();
	}
}
