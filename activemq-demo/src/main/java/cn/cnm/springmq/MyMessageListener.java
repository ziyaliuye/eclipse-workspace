package cn.cnm.springmq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

// 实现jms提供的监听器接口
public class MyMessageListener implements MessageListener {
	@Override
	public void onMessage(Message message) {
		if (null != message && message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			try {
				System.out.println(textMessage.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}
