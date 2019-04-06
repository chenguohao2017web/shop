package net.shop.category.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import net.shop.category.vo.Category;

public interface CategoryMapper {
	
	@Select("select * from category")
	List<Category> findAll();
	
}
