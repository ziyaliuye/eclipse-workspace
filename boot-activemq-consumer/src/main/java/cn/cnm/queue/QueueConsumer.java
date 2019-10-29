package cn.cnm.queue;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {
	// SpringBoot提供的注解， 参数是目的地名称（不需要指定是Queue还是Topic）
	@JmsListener(destination = "${myqueue}")
	public void receice(TextMessage textMessage) throws JMSException {
		System.out.println("接收到的消息：" + textMessage.getText());
	}
}
