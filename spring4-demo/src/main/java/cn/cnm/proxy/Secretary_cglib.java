package cn.cnm.proxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Secretary_cglib implements MethodInterceptor {
	// Object������cglib���ɵ�Boos���������
	// Method������������ķ���
	// Method���������ķ����Ĳ���
	// MethodProxy: ���ɵ����������д��ķ���
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("��ԤԼ��");
		// invoke ���ø���Ķ���ķ���
		// Object result = method.invoke(obj, args);
		// invokeSuper ����������д��ķ����� ��ʵ���ǵ��õĸ��෽�����߼���super()��
		// ע���� invokeSuper() ���� invoke(), д�� invoke() ����ѭ��
		Object result = proxy.invokeSuper(obj, args);
		System.out.println("��ע��Ϣ����");
		return result;
	}

}
