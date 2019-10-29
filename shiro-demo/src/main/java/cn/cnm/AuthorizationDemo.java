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
		// 授权之前必须先认证
		try {
			subject.login(token);
		} catch (Exception e) {
			System.out.println("用户登录失败");
		}
		// 基于角色的授权
		// 交由shiro来验证该用户是否有 role1 的权限
		// 返回true或者false， 不会抛出异常
		boolean flag = subject.hasRole("role2");
		System.out.println(flag);
		boolean[] flags = subject.hasRoles(Arrays.asList("role1", "role2"));
		System.out.println(flags[0]);
		System.out.println(flags[1]);
		System.out.println("================");
		// 检测是否具有某个角色， 没有则抛出 Authorize人Exception异常
		//subject.checkRole("role1");
		// subject.checkRoles(Arrays.asList("role1,role2"));
		
		// 基于资源的授权
		// 判断当前用户是否具有 user 的 delete 权限， 返回 Boolean类型
		flag = subject.isPermitted("user:delete");
		System.out.println(flag);
		// 判断用户是否具有多个权限， ， 返回 Boolean类型
		flag = subject.isPermittedAll("user:add", "user:update", "user:delete");
		System.out.println("----" +flag);

		// 判断用户是否有某个权限， 没有则抛出异常
		subject.checkPermission("user:delete");
	}
}
