package net.shop.categorySecond.vo;

import java.util.List;

import net.shop.product.vo.Product;

public class CategorySecond {
	private Integer csid;
	private String csname;
	
	//二级分类下有多个商品
	private List<Product> products;
	
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public Integer getCsid() {
		return csid;
	}
	public String getCsname() {
		return csname;
	}
}
