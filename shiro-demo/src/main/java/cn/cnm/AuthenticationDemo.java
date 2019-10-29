package cn.cnm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

// ����û���¼��֤
public class AuthenticationDemo {
	public static void main(String[] args) {
		// ͨ����ȡ�����ļ����� SecurityManager��������
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		// ��ȡ SecurityManager ʵ��
		SecurityManager sm = factory.getInstance();
		// �� SecurityManager������õ����л�����
		SecurityUtils.setSecurityManager(sm);
		// ͨ�� SecurityUtils ��ȡ���� Subject
		try {
			Subject subject = SecurityUtils.getSubject();
			// �����¼���û��� zhangsan �� 123, ע��������ģ���¼ʱ���ݹ�������Ϣ
			UsernamePasswordToken token = new UsernamePasswordToken("zhangsan1", "123");
			// ���������֤
			subject.login(token);
			// ͨ�� subject ���ж��û��Ƿ�ͨ����֤
			if (subject.isAuthenticated()) {
				System.out.println("�û���¼�ɹ�������");
			}
		} catch (UnknownAccountException e) {
			// �û�������ȷ
			System.out.println("�û��������벻��ȷ");
		} catch (IncorrectCredentialsException e) {
			// ���벻��ȷ
			System.out.println("�û��������벻��ȷ");
		}

	}
}
