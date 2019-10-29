package cn.cnm.model;

public class SingleTonPlus {
	// 构造方法私有， 不能被其他地方调用
	private SingleTonPlus() {
	};
	
	//　先不管怎么样， 在程序启动时就先创建好实例
	private static SingleTonPlus singleTonPlus = new SingleTonPlus();

	// 不管怎么调用都返回事先建立好的实例
	public static SingleTonPlus getInstance() {
		return singleTonPlus;
	}
}
