package cn.cnm;

import cn.cnm.proxy.Boos;
import cn.cnm.proxy.Secretary_cglib;
import net.sf.cglib.proxy.Enhancer;

public class CglibTest {

	public static void main(String[] args) {
		// cglib �ṩ��������������ʵ�������
		Enhancer enhancer = new Enhancer();
		// ָ�������ĸ��������
		enhancer.setSuperclass(Boos.class);
		// ���ûص��Ķ��� Ҳ��������Ķ������������ invoke �����������ܵķ����ģ�
		enhancer.setCallback(new Secretary_cglib());
		// ��������������
		Boos boos = (Boos) enhancer.create();
		boos.talk();
		boos.eat();
	}

}
