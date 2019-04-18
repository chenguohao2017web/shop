package net.shop.categorySecond.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import net.shop.categorySecond.vo.CategorySecond;

public interface CategorySecondMapper {

	// 根据一级分类id查询所有二级分类
	// 并且带上二级分类下所有的商品
	@Select("select * from categorysecond where cid = #{cid}")
	@Results({ @Result(column = "csid", property = "csid"),
			@Result(property = "products", column = "csid", many = @Many(select = "net.shop.product.mapper.ProductMapper.findProductsByCsid")) })
	List<CategorySecond> findByCid(String cid);

	// 查询所有的二级分类
	@Select("select * from categorysecond limit #{start}, #{pageSize}")
	List<CategorySecond> findAll(Integer start, Integer pageSize);

	// 查询所有的二级分类
	@Select("select count(*) from categorysecond")
	Long findCount();

	@Insert("insert into categorysecond set cid = #{category.cid}, csname = #{csname} ")
	void add(CategorySecond cs);
	
	//查询所有二级分类不带分页
	@Select("select * from categorysecond")
	List<CategorySecond> findAllList();

}
