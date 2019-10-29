package cn.cnm.queue;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsTopicConsumerListener {
	// ActiveMQ使用的是tcp协议（不要与前台访问的弄混了）
	public static final String ACTIVEMQ_URL = "tcp://192.168.58.128:61616";
	// 要访问的TOPIC的名称
	public static final String TOPIC_NAME = "topic01";

	public static void main(String[] args) throws JMSException, IOException {
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

		// 通过监听的方式消费队列 MessageListener 是一个接口， 所以这里需要new一个它的匿名实现类
//		messageConsumer.setMessageListener(new MessageListener() {
//			// 重写接收消息的方法
//			@Override
//			public void onMessage(Message message) {
//				// 如果消息不为空并且返回的消息对象是TextMessage类的实例则开始接收消息
//				if (null != message && message instanceof TextMessage) {
//					TextMessage textMessage = (TextMessage) message;
//					try {
//						System.out.println("2号消费者接订阅消息， 消息内容：" + textMessage.getText());
//					} catch (JMSException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		});

		// lambda表达式写法
		messageConsumer.setMessageListener((message) -> {
			if (null != message && message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				try {
					System.out.println("2号消费者接订阅消息， 消息内容：" + textMessage.getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});

		// 等待用户输入， 这里是为了阻塞程序让上面的消费者能消费完消息， 不会还没消费完消息程序就结束了
		System.in.read();

		// 关闭资源， 上面是一直阻塞这里是不会执行的
		messageConsumer.close();
		session.close();
		connection.close();
	}
}
