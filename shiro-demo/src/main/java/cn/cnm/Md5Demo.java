package cn.cnm;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class Md5Demo {

	public static void main(String[] args) {
		Md5Hash password = new Md5Hash("123");
		System.out.println(password);
		// ����(salt)�� �ڶ�������������ֵ
		password = new Md5Hash("123", "wocao");
		System.out.println(password);
		// �������� �����뷴�����ܼ���, �������������Ǽ��ܵĴ���
		password = new Md5Hash("123", "wocao", 3);
		System.out.println(password);
		// SimpleHash �� Md5Hash �ĸ��࣬ �����кܶ������������㷨
		// ��һ�����������㷨������
		SimpleHash hash = new SimpleHash("md5", "123", "wocao", 3);
		System.out.println(hash);
	}

}
