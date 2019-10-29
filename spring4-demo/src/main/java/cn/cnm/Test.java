package cn.cnm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cnm.service.AirportService;

public class Test {
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		// applicationContext 是一个接口， 只能new它的实现类
		// ClassPathXmlApplicationContext 从 java 的编译文件夹找 xml文件，参数就是 xml文件的名字
		applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		// 从过我们配置的 Bean 的标识获取对象， 但是这个是 Object 类型， 需要转换
		// People people = (People) applicationContext.getBean("people");
		// 第一个参数就是我们配置的 bean 的标识， 第二个就是该 bean 的对象类型， 获取后直接就是 People 类型
		// People people = applicationContext.getBean("people", People.class);
		// System.out.println(people);

		// 获取容器中所有的 bean 的名字并打印
		// String[] names = applicationContext.getBeanDefinitionNames();
		// for (String string : names) {
		// System.out.println(string);
		// }

		// 普通方式实例工厂创建对象
		// PeopleFactor factory = new PeopleFactor();
		// People people = factory.newInstance();

		AirportService airportService = applicationContext.getBean("airportService", AirportService.class);
		airportService.insertShangHai();
		System.out.println("OJBK!");

	}

}
