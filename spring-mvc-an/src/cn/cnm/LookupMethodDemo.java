package cn.cnm;

public class LookupMethodDemo {
	// ����һ���ӿ�
	interface MyCommand {
	}

	// ����ʵ����A
	class MyCommandA implements MyCommand {
		// ��������ʱ���ù��췽����ӡһ��
		public MyCommandA() {
			System.out.println("MyCommandA instanced");
		}
	}

	// ����ʵ����A
	class MyCommandB implements MyCommand {
		public MyCommandB() {
			System.out.println("MyCommandB instanced");
		}
	}

	// ����һ��������
	abstract class CommandManger {
		// ����һ�����󷽷��� ����ֵ���ǽӿ�
		// protected ���������ͬpackage�µ�����˵����public���������ⲿ�����private
		protected abstract MyCommand createCommand();

		// ��������ӡʵ����Ķ���
		public void process() {
			MyCommand myCommand = createCommand();
			System.out.println(myCommand);
		}
	}
}
