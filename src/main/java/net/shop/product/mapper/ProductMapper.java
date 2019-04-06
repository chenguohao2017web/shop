package net.shop.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import net.shop.product.vo.Product;

public interface ProductMapper {
	
	@Select("select * from product where is_hot=1 order by pdate limit 0, 10")
	List<Product> findHot();
	
	@Select("select * from product order by pdate limit 0,10")
	List<Product> findNew();
	
	@Select("select * from product where pid = #{pid}")
	Product findByPid(String pid);

}
