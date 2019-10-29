package cn.cnm.service;

import java.lang.reflect.Proxy;

import cn.cnm.proxy.Action;
import cn.cnm.proxy.Boos;
import cn.cnm.proxy.Secretary;

public class ProxyTest {

	public static void main(String[] args) {
		// jvm中类加载器是单例的， 所以不管调哪个类的类加载器其实都是用的同一个
		System.out.println(ProxyTest.class.getClassLoader() == Boos.class.getClassLoader());

		// 秘书类
		Secretary secretary = new Secretary();
		// 通过反射机制类加载器获取Action接口的实现类的对象Boss给接口Action（因为 Boss 实现了Action）
		// 第一个参数ProxyTest.class.getClassLoader()：反射时使用的类加载器
		// 第二个参数 new Class[] { Action.class }：Proxy 需要实现什么接口， 这里就一个 Action 接口
		// 第三个参数 secretary：就是秘书的实例， 通过接口对象调用方法时， 需要调用哪个类的 invoke 方法
		Action action = (Action) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[] { Action.class },
				secretary);
		// 这里不管调用什么方法，都是走的秘书的 invoke 方法， 它来负责调用真实对象的方法
		action.talk();
		action.eat();
	}

}
