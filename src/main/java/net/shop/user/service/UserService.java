package net.shop.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.shop.user.mapper.UserMapper;
import net.shop.user.vo.User;
@Transactional
@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	//根据用户名和密码查询用户
	public User findByUsernameAndPassword(User user) {
		return userMapper.findByUsernameAndPassword(user);
	}
	
	//根据用户名查询用户
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userMapper.findByUsername(username);
	}

	public void save(User user) {
		userMapper.save(user);
	}
}
