package cn.cnm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import cn.cnm.producer.QueueProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootActivemqApplicationTests {
	@Autowired
	private QueueProducer queueProducer;

	// 生产者
	@Test
	public void testSend() {
		queueProducer.produceMsg();
	};

}
