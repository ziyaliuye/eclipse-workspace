package cn.cnm.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

// ֻ��Ҫʵ�� spring aop �е� MethodBeforeAdvice ��д before ����ʵ��ǰ��֪ͨ 
public class MyBeforeAdvice implements MethodBeforeAdvice {
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("�е�ķ������� " + method + " ��������" + method.getName());
		if (args!=null && args.length > 0) {
			System.out.println("�е㷽���Ĳ����� " + args[0]);
		}
		System.out.println("�е�Ķ��� " + target);
		System.out.println("ǰ��֪ͨ!!!!!");
	}
}
