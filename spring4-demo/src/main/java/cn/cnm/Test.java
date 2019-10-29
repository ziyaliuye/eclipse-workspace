package cn.cnm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cnm.service.AirportService;

public class Test {
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		// applicationContext ��һ���ӿڣ� ֻ��new����ʵ����
		// ClassPathXmlApplicationContext �� java �ı����ļ����� xml�ļ����������� xml�ļ�������
		applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		// �ӹ��������õ� Bean �ı�ʶ��ȡ���� ��������� Object ���ͣ� ��Ҫת��
		// People people = (People) applicationContext.getBean("people");
		// ��һ�����������������õ� bean �ı�ʶ�� �ڶ������Ǹ� bean �Ķ������ͣ� ��ȡ��ֱ�Ӿ��� People ����
		// People people = applicationContext.getBean("people", People.class);
		// System.out.println(people);

		// ��ȡ���������е� bean �����ֲ���ӡ
		// String[] names = applicationContext.getBeanDefinitionNames();
		// for (String string : names) {
		// System.out.println(string);
		// }

		// ��ͨ��ʽʵ��������������
		// PeopleFactor factory = new PeopleFactor();
		// People people = factory.newInstance();

		AirportService airportService = applicationContext.getBean("airportService", AirportService.class);
		airportService.insertShangHai();
		System.out.println("OJBK!");

	}

}
