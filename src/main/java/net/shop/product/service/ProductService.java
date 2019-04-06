package net.shop.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.shop.product.mapper.ProductMapper;
import net.shop.product.vo.Product;

@Transactional
@Service
public class ProductService {
	@Autowired
	private ProductMapper productMapper;
	
	//获取十条热门商品
	public List<Product> findHot() {
		return productMapper.findHot();
	}
	
	//获取十条最新商品
	public List<Product> findNew() {
		return productMapper.findNew();
	}
	
	//根据id查询商品
	public Product findByPid(String pid) {
		return productMapper.findByPid(pid);
	}
	
}
