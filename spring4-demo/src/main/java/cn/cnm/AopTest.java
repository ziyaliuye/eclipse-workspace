package cn.cnm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cnm.demo.AopCase;

public class AopTest {

	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = new ClassPathXmlApplicationContext("application-context.xml");

		AopCase aopCase = applicationContext.getBean("aopDemo", AopCase.class);
		aopCase.demo2();
	}
}
