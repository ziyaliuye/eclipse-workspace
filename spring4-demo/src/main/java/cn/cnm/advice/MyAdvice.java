package cn.cnm.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// 类名、方法名都随意
@Component // 可以指定id名： @Component("aopCase") 默认不写值 id 就是对象名首字母小写
@Aspect // 表示该类为通知的一个切面类（通知注解基于 Aspect）
public class MyAdvice {
	// 从配置信息中获取参数， 注意参数名必须一致
	@After(value = "cn.cnm.demo.AopCase.demo2()")
	public void meBefore() {
		System.out.println("前置通知");
	}

	@After(value = "cn.cnm.demo.AopCase.demo2()")
	public void meAfter() {
		System.out.println("后置通知");
	}

	@AfterThrowing(value = "cn.cnm.demo.AopCase.demo2()")
	public void meThrow() {
		System.out.println("异常通知");
	}

	// 环绕通知稍微复杂点， 参数需要指定 ProceedingJoinPoint 也就是切点的对象
	@Around(value = "cn.cnm.demo.AopCase.demo2()")
	public Object meArround(ProceedingJoinPoint point) throws Throwable {
		System.out.println("环绕通知");
		System.out.println("前置通知");
		// 放行， 并且获取切点执行完后的返回值
		Object obj = point.proceed();
		System.out.println("后置通知");
		return obj;
	}

	// @Before 表示该方法为前置通知， 参数对应的是切点名

	/*
	 * @Before(value = "cn.cnm.demo.AopCase.demo2(String,int) && args(name,age)",
	 * argNames = "name,age") public void meBefore(String name, int age) {
	 * System.out.println("前置通知"); System.out.println("name：" + name);
	 * System.out.println("int：" + age); }
	 */

}
