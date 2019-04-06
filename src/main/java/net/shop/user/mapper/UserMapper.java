package net.shop.user.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import net.shop.user.vo.User;

public interface UserMapper {

	@Select("select * from user where username = #{username} and password = #{password}")
	User findByUsernameAndPassword(User user);
	
	@Select("select * from user where username= #{username}")
	User findByUsername(String username);
	
	@Insert("insert into user (username, password, email, name,sex,addr) "
			+ "values(#{username}, #{password}, #{email}, #{name}, #{sex}, #{addr})")
	void save(User user);
}
