package cn.cnm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Secretary implements InvocationHandler {
	private Boos boos = new Boos();

	// Object����������ʵ����������ʵ�����ʵ���� method����ʵ����ķ��� Object[]����ʵ����Ĳ���
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("��ԤԼ��");
		// ��Ҫ�� Boos ��ʵ���������У� ��main�����л᷵��һ��������ʵ����Action�ӿڲ����ж��⹦�ܵ�һ�������Action�ӿ�
		// ע�������� �������Ķ������ invoke ������ ����������صĶ����ʲô���������� invoke ����
		Object result = method.invoke(boos, args);
		System.out.println("��ע��Ϣ����");
		return result;
	}
}
