package cn.cnm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class AuthenticationJdbcRealm {

	public static void main(String[] args) {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro_costom.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123");
		try {
			subject.login(token);
			if (subject.isAuthenticated()) {
				System.out.println("用户登录成功");
			}
		} catch (Exception e) {
			System.out.println("用户登录失败");
		}
	}

}
