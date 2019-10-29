package cn.cnm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

// 完成用户登录认证
public class AuthenticationDemo {
	public static void main(String[] args) {
		// 通过读取配置文件创建 SecurityManager工厂对象
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		// 获取 SecurityManager 实例
		SecurityManager sm = factory.getInstance();
		// 将 SecurityManager对象放置到运行环境中
		SecurityUtils.setSecurityManager(sm);
		// 通过 SecurityUtils 获取主体 Subject
		try {
			Subject subject = SecurityUtils.getSubject();
			// 假设登录的用户名 zhangsan 和 123, 注意这里是模拟登录时传递过来的信息
			UsernamePasswordToken token = new UsernamePasswordToken("zhangsan1", "123");
			// 进行身份验证
			subject.login(token);
			// 通过 subject 来判断用户是否通过验证
			if (subject.isAuthenticated()) {
				System.out.println("用户登录成功！！！");
			}
		} catch (UnknownAccountException e) {
			// 用户名不正确
			System.out.println("用户或者密码不正确");
		} catch (IncorrectCredentialsException e) {
			// 密码不正确
			System.out.println("用户或者密码不正确");
		}

	}
}
