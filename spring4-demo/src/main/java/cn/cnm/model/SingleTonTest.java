package cn.cnm.model;

public class SingleTonTest {

	public static void main(String[] args) {
		// ���þ�̬�ķ�����ȡʵ��
		SingleTon singleTon1 = SingleTon.getInstance();
		SingleTon singleTon2 = SingleTon.getInstance();
		System.out.println(singleTon1 == singleTon2);

		// ���þ�̬�ķ�����ȡʵ��
		SingleTonPlus singleTonPlus1 = SingleTonPlus.getInstance();
		SingleTonPlus singleTonPlus2 = SingleTonPlus.getInstance();
		System.out.println(singleTonPlus1 == singleTonPlus2);
	}

}
