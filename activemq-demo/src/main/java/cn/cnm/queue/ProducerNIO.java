package cn.cnm.queue;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ProducerNIO {

	public static void main(String[] args) throws JMSException {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
				"nio://192.168.58.128:61608");
		Connection connection = activeMQConnectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue("nio_demo");
		MessageProducer messageProducer = session.createProducer(queue);
		messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
		// 创建MapMessage
		MapMessage mapMessage = session.createMapMessage();
		// 设置一个属性 key-value
		mapMessage.setString("key1", "hehe");
		// 设置消息属性
		mapMessage.setStringProperty("username", "wocao");
		mapMessage.setBoolean("isVip", true);
		messageProducer.send(mapMessage);
		messageProducer.close();
		// 在Session关闭之前commit消息才回真正的生产
		// session.commit();
		session.close();
		connection.close();
	}

}
