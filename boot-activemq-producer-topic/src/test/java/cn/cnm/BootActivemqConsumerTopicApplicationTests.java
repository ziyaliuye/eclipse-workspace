package cn.cnm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.cnm.producer.TopicProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootActivemqConsumerTopicApplicationTests {
	@Autowired
	private TopicProducer topicProducer;

	@Test
	public void test() {
		topicProducer.produceTopic();
	}
}
