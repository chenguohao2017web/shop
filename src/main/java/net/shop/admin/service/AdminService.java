package net.shop.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.shop.admin.mapper.AdminMapper;
import net.shop.admin.vo.AdminUser;

@Service
@Transactional
public class AdminService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	public AdminUser findByUsernameAndPassword(String username, String password) {
		return adminMapper.findByUsernameAndPassword(username, password);
	}
	
}
