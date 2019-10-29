package cn.cnm.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// ������������������
@Component // ����ָ��id���� @Component("aopCase") Ĭ�ϲ�дֵ id ���Ƕ���������ĸСд
@Aspect // ��ʾ����Ϊ֪ͨ��һ�������֪ࣨͨע����� Aspect��
public class MyAdvice {
	// ��������Ϣ�л�ȡ������ ע�����������һ��
	@After(value = "cn.cnm.demo.AopCase.demo2()")
	public void meBefore() {
		System.out.println("ǰ��֪ͨ");
	}

	@After(value = "cn.cnm.demo.AopCase.demo2()")
	public void meAfter() {
		System.out.println("����֪ͨ");
	}

	@AfterThrowing(value = "cn.cnm.demo.AopCase.demo2()")
	public void meThrow() {
		System.out.println("�쳣֪ͨ");
	}

	// ����֪ͨ��΢���ӵ㣬 ������Ҫָ�� ProceedingJoinPoint Ҳ�����е�Ķ���
	@Around(value = "cn.cnm.demo.AopCase.demo2()")
	public Object meArround(ProceedingJoinPoint point) throws Throwable {
		System.out.println("����֪ͨ");
		System.out.println("ǰ��֪ͨ");
		// ���У� ���һ�ȡ�е�ִ�����ķ���ֵ
		Object obj = point.proceed();
		System.out.println("����֪ͨ");
		return obj;
	}

	// @Before ��ʾ�÷���Ϊǰ��֪ͨ�� ������Ӧ�����е���

	/*
	 * @Before(value = "cn.cnm.demo.AopCase.demo2(String,int) && args(name,age)",
	 * argNames = "name,age") public void meBefore(String name, int age) {
	 * System.out.println("ǰ��֪ͨ"); System.out.println("name��" + name);
	 * System.out.println("int��" + age); }
	 */

}
