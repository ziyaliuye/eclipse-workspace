package cn.cnm.queue;

import java.io.IOException;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ConsumerNIO {

	public static void main(String[] args) throws JMSException, IOException {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
				"nio://192.168.58.128:61608");
		Connection connection = activeMQConnectionFactory.createConnection();
		connection.start();
		// 第一个参数为事务 true表示开启事务  false表示关闭事务
		// 第二个参数为签收模式的设置
		Session session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);
		Queue queue = session.createQueue("nio_demo");
		MessageConsumer messageConsumer = session.createConsumer(queue);
		messageConsumer.setMessageListener(message -> {
			if (null != message && message instanceof MapMessage) {
				MapMessage mapMessage = (MapMessage) message;
				try {
					System.out.println("接收消息：" + mapMessage.getString("key1"));
					System.out.println("消息属性username：" + mapMessage.getStringProperty("username"));
					System.out.println("消息属性isVip：" + mapMessage.getBooleanProperty("isVip"));
					// 消费完消息后需要显式调用签收， 告诉ActiveMQ已经消费完消息了
				//mapMessage.acknowledge();
				} catch (JMSException e) {
					e.printStackTrace();
					
				}
			}
		});
		System.in.read();
		messageConsumer.close();
		// 在 Session关闭之前进行 commit， 否则消息一直处于未消费状态
		session.commit();
		session.close();
		connection.close();
	}

}
