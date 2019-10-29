package cn.cnm;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class AuthorizationDemo {

	public static void main(String[] args) {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro_costom.ini");
		SecurityManager sm = factory.getInstance();
		SecurityUtils.setSecurityManager(sm);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123");
		// ��Ȩ֮ǰ��������֤
		try {
			subject.login(token);
		} catch (Exception e) {
			System.out.println("�û���¼ʧ��");
		}
		// ���ڽ�ɫ����Ȩ
		// ����shiro����֤���û��Ƿ��� role1 ��Ȩ��
		// ����true����false�� �����׳��쳣
		boolean flag = subject.hasRole("role2");
		System.out.println(flag);
		boolean[] flags = subject.hasRoles(Arrays.asList("role1", "role2"));
		System.out.println(flags[0]);
		System.out.println(flags[1]);
		System.out.println("================");
		// ����Ƿ����ĳ����ɫ�� û�����׳� Authorize��Exception�쳣
		//subject.checkRole("role1");
		// subject.checkRoles(Arrays.asList("role1,role2"));
		
		// ������Դ����Ȩ
		// �жϵ�ǰ�û��Ƿ���� user �� delete Ȩ�ޣ� ���� Boolean����
		flag = subject.isPermitted("user:delete");
		System.out.println(flag);
		// �ж��û��Ƿ���ж��Ȩ�ޣ� �� ���� Boolean����
		flag = subject.isPermittedAll("user:add", "user:update", "user:delete");
		System.out.println("----" +flag);

		// �ж��û��Ƿ���ĳ��Ȩ�ޣ� û�����׳��쳣
		subject.checkPermission("user:delete");
	}
}
