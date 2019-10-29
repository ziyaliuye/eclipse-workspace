package cn.cnm.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

// 只需要实现 spring aop 中的 MethodBeforeAdvice 重写 before 就能实现前置通知 
public class MyBeforeAdvice implements MethodBeforeAdvice {
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("切点的方法对象： " + method + " 方法名：" + method.getName());
		if (args!=null && args.length > 0) {
			System.out.println("切点方法的参数： " + args[0]);
		}
		System.out.println("切点的对象： " + target);
		System.out.println("前置通知!!!!!");
	}
}
