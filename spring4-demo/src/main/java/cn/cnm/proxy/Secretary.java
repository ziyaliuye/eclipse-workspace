package cn.cnm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Secretary implements InvocationHandler {
	private Boos boos = new Boos();

	// Object：代理对象的实例（不是真实对象的实例） method：真实对象的方法 Object[]：真实对象的参数
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("有预约吗？");
		// 需要将 Boos 的实例传入其中， 在main发放中会返回一个类似于实现了Action接口并带有额外功能的一个对象给Action接口
		// 注意这里是 方法名的对象调用 invoke 方法， 不管这个返回的对象调什么方法都会走 invoke 方法
		Object result = method.invoke(boos, args);
		System.out.println("备注信息！！");
		return result;
	}
}
