package cn.cnm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cnm.mapper.UserMapper;
import cn.cnm.pojo.User;
import cn.cnm.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	public List<User> selectALl() {
		return userMapper.selectAll();
	}

}
