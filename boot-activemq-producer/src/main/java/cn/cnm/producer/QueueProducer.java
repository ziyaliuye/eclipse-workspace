package cn.cnm.producer;

import javax.jms.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class QueueProducer {
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	// 这是jms中的类， 但是在 ConfigBean中已经将其实例放入Spring容器中了
	// 所以这里获取到就是ConfigBean中返回的实例
	@Autowired
	private Queue queue;

	// 生产消息
	public void produceMsg() {
		// 发送并且自动转换类型， 将消息发送到指定的队列中
		// 第一个参数队列的实例
		// 第二个参数是要发送的消息内容
		jmsMessagingTemplate.convertAndSend(queue, "SpringBoot Message Produce Success...");
	}

	// 定时生产消息, 每3秒执行一次
	@Scheduled(fixedDelay = 3000)
	public void produceMsgScheduled() {
		// 发送并且自动转换类型， 将消息发送到指定的队列中
		// 第一个参数队列的实例
		// 第二个参数是要发送的消息内容
		jmsMessagingTemplate.convertAndSend(queue, "Scheduled SpringBoot Message Produce Success...");
		System.out.println("开始发消息了哦....");
	}
}
