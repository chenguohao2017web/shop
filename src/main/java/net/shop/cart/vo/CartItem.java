package net.shop.cart.vo;

import net.shop.product.vo.Product;

public class CartItem {
	private Product product;
	private Integer count; // 购买个数
	private Double subTotal; // 小计
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getSubTotal() {
		return product.getShop_price() * count;
	}
	
}
