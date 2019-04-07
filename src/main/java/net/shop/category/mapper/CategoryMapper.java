package net.shop.category.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import net.shop.category.vo.Category;
import net.shop.categorySecond.vo.CategorySecond;

public interface CategoryMapper {
	
	//查询所有的一级分类 
	//带上所有的二级分类一对多配置
	@Select("select * from category")
	@Results({
		@Result(column = "cid",property = "cid"), //一级分类参数丢失，手动配上
		@Result(property = "categoryseconds", column = "cid", //property 一方的集合名称 ，column查询参数
				many=@Many(select = "net.shop.categorySecond.mapper.CategorySecondMapper.findByCid"))
	})
	List<Category> findAll();
	
	
}
