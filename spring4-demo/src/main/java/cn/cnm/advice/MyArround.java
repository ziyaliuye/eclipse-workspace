package cn.cnm.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyArround implements MethodInterceptor {
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// �� proceed �����У� ִ���е㷽����֮ǰ����ǰ��֪ͨ
		System.out.println("����֪ͨ��ǰ��");
		// ���У� �����е�ķ���
		Object obj = invocation.proceed();
		// �� proceed �����У� ִ���е㷽����֮����Ǻ���֪ͨ
		System.out.println("����֪ͨ������");
		return null;
	}
}
