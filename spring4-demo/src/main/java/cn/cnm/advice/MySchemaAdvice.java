package cn.cnm.advice;

import org.springframework.aop.ThrowsAdvice;

public class MySchemaAdvice implements ThrowsAdvice {
	// ���ﲻ����д�ӿڵķ����� �����½��ķ����� ���ֻ��ð�Ҫ��д���
	// �ٷ�������д RemoteException �ͻᲶ׽������ �������д��׼�쳣���ͻ���ֱ��д Exception
	public void afterThrowing(Exception ex) throws Throwable {
		System.out.println("ִ���� SchemaAdvice �쳣֪ͨ");
	}

}
