package cn.cnm.model;

public class SingleTon {
	// 由于对象需要被静态方法调用， 所以变量也得设置为接警台
	private static SingleTon singleTon;

	private SingleTon() {

	}

	// 获取实例方法， 其他地方必须通过这个方法来获取对象的引用
	// 因为类的构造方法已经被设置为private，只能将方法设置为静态以供调用
	public static SingleTon getInstance() {
		// 多线程访问下， 可能会出现if条件同时成立的情况， 必须添加锁
		if (singleTon == null) {
			synchronized (SingleTon.class) {
				// 双重验证， 比如第一个线程进来并调用完， 第二个线程等待执行时， singleTon其实还是空的
				if (singleTon == null) {
					singleTon = new SingleTon();
				}
			}
		}
		return singleTon;
	}
}
