package net.shop.category.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	
	//新增一級分類
	@Insert("insert into category(cname) values(#{name})")
	void add(String name);
	
	//根據id刪除一級分類
	@Delete("delete from category where cid = #{cid}")
	void delByCid(String cid);
	
	//根據id查詢一級分類
	@Select("select * from category where cid = #{cid}")
	Category findByCid(String cid);
	
	//跟新一級分類
	@Update("update category set cname = #{cname} where cid = #{cid}")
	void update(Category category);
	
	
}
