package cn.cnm.advice;

public class MyThrowAdvice {
	// �����ͷ��������⣬ ��� spring �����ļ��������� <aop:after-throwing> �� throwing ����
	// Ҫ���Ͳ�д������ Ҫ���������� Exception�� �������������ļ�����һ�� ��Ȼ�ᱨ��
	public void mythorw(Exception e) {
		System.out.println("���쳣������");
		System.out.println(e);
	}
}
