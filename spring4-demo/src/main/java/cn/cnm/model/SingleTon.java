package cn.cnm.model;

public class SingleTon {
	// ���ڶ�����Ҫ����̬�������ã� ���Ա���Ҳ������Ϊ�Ӿ�̨
	private static SingleTon singleTon;

	private SingleTon() {

	}

	// ��ȡʵ�������� �����ط�����ͨ�������������ȡ���������
	// ��Ϊ��Ĺ��췽���Ѿ�������Ϊprivate��ֻ�ܽ���������Ϊ��̬�Թ�����
	public static SingleTon getInstance() {
		// ���̷߳����£� ���ܻ����if����ͬʱ����������� ���������
		if (singleTon == null) {
			synchronized (SingleTon.class) {
				// ˫����֤�� �����һ���߳̽����������꣬ �ڶ����̵߳ȴ�ִ��ʱ�� singleTon��ʵ���ǿյ�
				if (singleTon == null) {
					singleTon = new SingleTon();
				}
			}
		}
		return singleTon;
	}
}
