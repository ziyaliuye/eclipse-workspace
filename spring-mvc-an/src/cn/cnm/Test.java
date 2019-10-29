package cn.cnm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cnm.LookupMethodDemo.CommandManger;

public class Test {

	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		CommandManger commandManger = context.getBean("commandManger", CommandManger.class);
		System.out.println(commandManger.getClass().getName());
		commandManger.process();
	}

}
