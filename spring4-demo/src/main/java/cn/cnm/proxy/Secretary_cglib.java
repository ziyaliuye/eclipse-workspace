package cn.cnm.proxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Secretary_cglib implements MethodInterceptor {
	// Object：就是cglib生成的Boos的子类对象
	// Method：子类对象代理的方法
	// Method：子类对象的方法的参数
	// MethodProxy: 生成的子类对象重写后的方法
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("有预约吗？");
		// invoke 调用父类的对象的方法
		// Object result = method.invoke(obj, args);
		// invokeSuper 调用子类重写后的方法， 其实还是调用的父类方法的逻辑（super()）
		// 注意是 invokeSuper() 不是 invoke(), 写成 invoke() 会死循环
		Object result = proxy.invokeSuper(obj, args);
		System.out.println("备注信息！！");
		return result;
	}

}
