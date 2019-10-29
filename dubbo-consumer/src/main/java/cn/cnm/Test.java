package cn.cnm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.cnm.service.impl.TestServiceImpl;

public class Test {
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = new ClassPathXmlApplicationContext(
				"classpath:/META-INF/spring/applicationContext-dubbo.xml");
		TestServiceImpl testServiceImpl = applicationContext.getBean("testServiceImpl", TestServiceImpl.class);
		testServiceImpl.test();
	}

}
