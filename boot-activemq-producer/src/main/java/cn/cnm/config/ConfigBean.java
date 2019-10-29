package cn.cnm.config;

import javax.jms.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

// 让Spring能扫描到
@Component
// 开启jms服务支持， 不然不生效
@EnableJms
public class ConfigBean {
	// 将配置文件中的自定义的属性添加进来
	@Value("${myqueue}")
	private String myQueue;

	// 这些方法会自动创建一个实例并放入Spring的容器中， 其他地方可以直接调用
	@Bean
	public Queue queue() {
		// 创建一个队列实例， 队列名由配置文件决定
		return new ActiveMQQueue(myQueue);
	}
}
