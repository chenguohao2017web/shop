package net.shop.admin.mapper;

import org.apache.ibatis.annotations.Select;

import net.shop.admin.vo.AdminUser;

public interface AdminMapper {

	@Select("select * from adminuser where username = #{username} and password= #{password}")
	AdminUser findByUsernameAndPassword(String username, String password);

}
