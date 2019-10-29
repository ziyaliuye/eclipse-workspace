package cn.cnm;

public class LookupMethodDemo {
	// 定义一个接口
	interface MyCommand {
	}

	// 定义实现类A
	class MyCommandA implements MyCommand {
		// 当被创建时调用构造方法打印一下
		public MyCommandA() {
			System.out.println("MyCommandA instanced");
		}
	}

	// 定义实现类A
	class MyCommandB implements MyCommand {
		public MyCommandB() {
			System.out.println("MyCommandB instanced");
		}
	}

	// 定义一个抽象类
	abstract class CommandManger {
		// 定义一个抽象方法， 返回值就是接口
		// protected 对于子类和同package下的类来说就是public，其他的外部类就是private
		protected abstract MyCommand createCommand();

		// 创建并打印实现类的对象
		public void process() {
			MyCommand myCommand = createCommand();
			System.out.println(myCommand);
		}
	}
}
