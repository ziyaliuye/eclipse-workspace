package cn.cnm.topic;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {
	// SpringBoot提供的注解， 参数是目的地名称（不需要指定是Queue还是Topic）
	@JmsListener(destination = "${mytopic}")
	public void receive(TextMessage textMessage) throws JMSException {
		System.out.println(textMessage.getText());
	}
}
