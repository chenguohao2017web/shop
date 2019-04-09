package net.shop.order.vo;

import net.shop.product.vo.Product;

public class OrderItem {
	private Integer itemId;
	private Integer count;
	private Double subtotal;
	
	//对应的商品
	private Product product;
	//对应的订单
	private Order order;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getSubTotal() {
		return subtotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subtotal = subTotal;
	}
	
}
