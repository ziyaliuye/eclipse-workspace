package cn.cnm.demo;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // 可以指定id名： @Component("aopCase") 默认不写值 id 就是对象名首字母小写
public class AopCase {
	public void demo1() {
		System.out.println("demo1");
	}

	// 表示方法为切点, cn.cnm.demo.AopCase.demo2(String,int) && args(name,age) 则是切点的id， 绑定 advice 时要用到
	@Pointcut(value = "execution(* cn.cnm.demo.AopCase.demo2(String,int)) && args(name,age)", argNames = "name,age")
	public void demo2(String name, int age) {
		System.out.println("demo2");
	}

	// 表示方法为切点, cn.cnm.demo.AopCase.demo2() 则是切点的id， 绑定 advice 时要用到
	@Pointcut(value = "execution(* cn.cnm.demo.AopCase.demo2())")
	public void demo2() {
		System.out.println("demo2");
	}

	public void demo3() {
		System.out.println("demo3");
	}
}
