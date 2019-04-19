package net.shop.product.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import net.shop.product.vo.Product;

public interface ProductMapper {
	
	@Select("select * from product where is_hot=1 order by pdate limit 0, 10")
	List<Product> findHot();
	
	@Select("select * from product order by pdate limit 0,10")
	List<Product> findNew();
	
	//根据商品id 查询商品
	@Select("select * from product where pid = #{pid}")
	Product findByPid(String pid);
	
	//根据二级分类id查询所有商品
	@Select("select * from product where csid = #{csid}")
	List<Product> findProductsByCsid(String csid);

	//根据一级分类id查询所有的商品
	@Select("select * from product p, categorysecond cs where p.csid = cs.csid and cs.csid = #{cid} limit #{start}, #{pageSize} ")
	List<Product> findProductsByCid(String cid, Integer start, Integer pageSize);

	//根据一级分类id 查询所有的商品条数
	@Select("select count(*) from product p, categorysecond cs where p.csid = cs.csid and cs.csid = #{cid}")
	Integer findProductCountByCid(String cid);
	
	
	//根据二级分类id 查询所有商品 带分页
	@Select("select * from product p where csid = #{csid} limit #{start}, #{pageSize}")
	List<Product> getProductsByCsid(String csid, Integer start, Integer pageSize);
	
	//根据二级分类id 获取总数
	@Select("select count(*) from product where product.csid = #{csid}")
	Integer getCountByCsid(String csid);

	@Select("select count(*) from product")
	Integer findCount();
	
	//查询所有商品带分页
	@Select("select * from product limit #{start},#{pageSize}")
	ArrayList<Product> findAll(Integer start, Integer pageSize);
	
	//保存商品
	@Insert("insert into product "
			+ "set pname = #{pname},"
			+ "market_price = #{market_price}, "
			+ "shop_price = #{shop_price}, "
			+ "image=#{image}, pdesc=#{pdesc}, "
			+ "is_hot=#{is_hot}, pdate=#{pdate}, "
			+ "csid=#{csid}")
	void save(Product product);
	
}
