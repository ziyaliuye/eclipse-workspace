package cn.cnm.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyArround implements MethodInterceptor {
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// 在 proceed （放行， 执行切点方法）之前就是前置通知
		System.out.println("环绕通知：前置");
		// 放行， 调用切点的方法
		Object obj = invocation.proceed();
		// 在 proceed （放行， 执行切点方法）之后就是后置通知
		System.out.println("环绕通知：后置");
		return null;
	}
}
