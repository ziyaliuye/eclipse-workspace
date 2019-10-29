package cn.cnm.demo;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // ����ָ��id���� @Component("aopCase") Ĭ�ϲ�дֵ id ���Ƕ���������ĸСд
public class AopCase {
	public void demo1() {
		System.out.println("demo1");
	}

	// ��ʾ����Ϊ�е�, cn.cnm.demo.AopCase.demo2(String,int) && args(name,age) �����е��id�� �� advice ʱҪ�õ�
	@Pointcut(value = "execution(* cn.cnm.demo.AopCase.demo2(String,int)) && args(name,age)", argNames = "name,age")
	public void demo2(String name, int age) {
		System.out.println("demo2");
	}

	// ��ʾ����Ϊ�е�, cn.cnm.demo.AopCase.demo2() �����е��id�� �� advice ʱҪ�õ�
	@Pointcut(value = "execution(* cn.cnm.demo.AopCase.demo2())")
	public void demo2() {
		System.out.println("demo2");
	}

	public void demo3() {
		System.out.println("demo3");
	}
}
