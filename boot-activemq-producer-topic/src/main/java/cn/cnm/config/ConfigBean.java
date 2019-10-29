package cn.cnm.config;

import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class ConfigBean {
	// 从配置文件获取Topic名称
	@Value("${mytopic}")
	private String topicName;

	// 这些方法会自动创建一个实例并放入Spring的容器中， 其他地方可以直接调用
	@Bean
	public Topic topic() {
		return new ActiveMQTopic(topicName);
	}
}
