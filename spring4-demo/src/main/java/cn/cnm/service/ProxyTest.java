package cn.cnm.service;

import java.lang.reflect.Proxy;

import cn.cnm.proxy.Action;
import cn.cnm.proxy.Boos;
import cn.cnm.proxy.Secretary;

public class ProxyTest {

	public static void main(String[] args) {
		// jvm����������ǵ����ģ� ���Բ��ܵ��ĸ�������������ʵ�����õ�ͬһ��
		System.out.println(ProxyTest.class.getClassLoader() == Boos.class.getClassLoader());

		// ������
		Secretary secretary = new Secretary();
		// ͨ������������������ȡAction�ӿڵ�ʵ����Ķ���Boss���ӿ�Action����Ϊ Boss ʵ����Action��
		// ��һ������ProxyTest.class.getClassLoader()������ʱʹ�õ��������
		// �ڶ������� new Class[] { Action.class }��Proxy ��Ҫʵ��ʲô�ӿڣ� �����һ�� Action �ӿ�
		// ���������� secretary�����������ʵ���� ͨ���ӿڶ�����÷���ʱ�� ��Ҫ�����ĸ���� invoke ����
		Action action = (Action) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[] { Action.class },
				secretary);
		// ���ﲻ�ܵ���ʲô�����������ߵ������ invoke ������ �������������ʵ����ķ���
		action.talk();
		action.eat();
	}

}
