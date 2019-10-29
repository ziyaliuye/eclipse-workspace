package cn.cnm.producer;

import javax.jms.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class TopicProducer {
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	// 这是jms中的类， 但是在 ConfigBean中已经将其实例放入Spring容器中了
	// 所以这里获取到就是ConfigBean中返回的实例
	@Autowired
	private Topic topic;

	// 发送并且自动转换类型， 将消息发送到指定的队列中
	// 第一个参数队列的实例
	// 第二个参数是要发送的消息内容
	public void produceTopic() {
		jmsMessagingTemplate.convertAndSend(topic, "Topic produce...");
	}
}
