package cn.cnm.model;

public class SingleTonPlus {
	// ���췽��˽�У� ���ܱ������ط�����
	private SingleTonPlus() {
	};
	
	//���Ȳ�����ô���� �ڳ�������ʱ���ȴ�����ʵ��
	private static SingleTonPlus singleTonPlus = new SingleTonPlus();

	// ������ô���ö��������Ƚ����õ�ʵ��
	public static SingleTonPlus getInstance() {
		return singleTonPlus;
	}
}
