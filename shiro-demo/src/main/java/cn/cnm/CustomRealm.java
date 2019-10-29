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

// �̳� AuthorizingRrealm�� �����������ṩ���֤��֤������ Ҳ����ʵ����Ȩ
public class CustomRealm extends AuthorizingRealm {
	// ��ȡ��֤��Ϣ�� ������֤��֤ʧ�ܣ� ����null
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// ��ȡ�����֤��Ϣ
		// ��ȡ�û�������û���
		String username = token.getPrincipal().toString();
		System.out.println("�����û���Ϊ��" + username);
		// ʵ�ʲ����и����û�������û��������ݿ��ѯ������Ϣ����ֵ
		// ������ʱд��ֵ123�� Ȼ�󵱵���shiro�������֤ʱ�ͻ��������ֵ�����123���Ƚ�
		String password = "734192eb3d7daa93b4917e26a748c8ee";
		String salt = "wocao";
		// ���֤��֤��Ϣ�� ����ǰ���������ֱ����û������룬 ������Ϊmd5���ܵ���ֵ�� ���ĸ��������Զ���Realm�ĸ����Դ��ķ���
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, ByteSource.Util.bytes(salt),
				getName());
		return info;
	}

	// ��ȡȨ����Ϣ
	@Override
	// principals �������֤��Ϣ����
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = principals.getPrimaryPrincipal().toString();
		System.out.println("��Ȩ....");
		System.out.println("username��" + username);
		// ���������û��������ݿ��ѯ�û���Ӧ��Ȩ����Ϣ�� ����д��ֵ
		List<String> permission = new ArrayList<String>();
		permission.add("user:add");
		permission.add("user:delete");
		permission.add("user:update");
		permission.add("user:add");
		permission.add("user:find");

		// �������ݿ��ѯ����Ȩ�޶�����������ϣ�����ֵҪ��������ͣ�
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		for (String perms : permission) {
			info.addStringPermission(perms);
		}
		return info;
	}
}











