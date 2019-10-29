package cn.cnm;

import cn.cnm.proxy.Boos;
import cn.cnm.proxy.Secretary_cglib;
import net.sf.cglib.proxy.Enhancer;

public class CglibTest {

	public static void main(String[] args) {
		// cglib 提供的类用于生成真实类的子类
		Enhancer enhancer = new Enhancer();
		// 指定生成哪个类的子类
		enhancer.setSuperclass(Boos.class);
		// 设置回调的对象， 也就是秘书的对象（是由秘书的 invoke 方法来调老总的方法的）
		enhancer.setCallback(new Secretary_cglib());
		// 创建这个子类对象
		Boos boos = (Boos) enhancer.create();
		boos.talk();
		boos.eat();
	}

}
