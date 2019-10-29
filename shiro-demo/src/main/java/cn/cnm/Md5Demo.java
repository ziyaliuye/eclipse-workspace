package cn.cnm;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class Md5Demo {

	public static void main(String[] args) {
		Md5Hash password = new Md5Hash("123");
		System.out.println(password);
		// 加盐(salt)， 第二个参数就是盐值
		password = new Md5Hash("123", "wocao");
		System.out.println(password);
		// 迭代次数 将密码反复加密几次, 第三个参数就是加密的次数
		password = new Md5Hash("123", "wocao", 3);
		System.out.println(password);
		// SimpleHash 是 Md5Hash 的父类， 它还有很多其他的密码算法
		// 第一个参数就是算法的名称
		SimpleHash hash = new SimpleHash("md5", "123", "wocao", 3);
		System.out.println(hash);
	}

}
