package cn.cnm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

// 继承 AuthorizingRrealm， 这样即可以提供身份证认证方法， 也可以实现授权
public class CustomRealm extends AuthorizingRealm {
	// 获取认证信息， 如果身份证认证失败， 返回null
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取身份认证信息
		// 获取用户输入的用户名
		String username = token.getPrincipal().toString();
		System.out.println("输入用户名为：" + username);
		// 实际操作中根据用户输入的用户名到数据库查询密码信息和盐值
		// 这里暂时写死值123， 然后当调用shiro的身份认证时就会拿输入的值和这个123做比较
		String password = "734192eb3d7daa93b4917e26a748c8ee";
		String salt = "wocao";
		// 身份证认证信息， 这里前两个参数分别是用户名密码， 第三个为md5加密的盐值， 第四个参数是自定义Realm的父类自带的方法
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, ByteSource.Util.bytes(salt),
				getName());
		return info;
	}

	// 获取权限信息
	@Override
	// principals 就是身份证信息集合
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = principals.getPrimaryPrincipal().toString();
		System.out.println("授权....");
		System.out.println("username：" + username);
		// 后续根据用户名在数据库查询用户对应的权限信息， 这里写死值
		List<String> permission = new ArrayList<String>();
		permission.add("user:add");
		permission.add("user:delete");
		permission.add("user:update");
		permission.add("user:add");
		permission.add("user:find");

		// 将从数据库查询到的权限都加入这个集合（返回值要求这个类型）
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		for (String perms : permission) {
			info.addStringPermission(perms);
		}
		return info;
	}
}











