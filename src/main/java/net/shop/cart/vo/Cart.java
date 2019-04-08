package net.shop.cart.vo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<Integer,CartItem> map = new HashMap<>();
	private Double total = (double) 0;
	
	public Collection getCartItems() {
		return map.values();
	}
	
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}

	//将商品添加到购物车
	public void addCartItem(CartItem cartItem) {
		
		/**
		 * 根据id判断是否存在
		 * 	如果存在：数目相加
		 * 	如果不存在：直接添加到集合
		 * 最后改变总价
		 */
		Integer pid = cartItem.getProduct().getPid();
		if(map.containsKey(pid)) {
			//已经存在改商品
			CartItem origin_cartItem = map.get(pid);
			origin_cartItem.setCount(origin_cartItem.getCount() + cartItem.getCount());
		} else {
			map.put(cartItem.getProduct().getPid(), cartItem);
		}
		
		this.setTotal(this.getTotal() + cartItem.getSubTotal());
		
	}
	
	//将商品从购物车移除
	public void removeCartItem(Integer pid) {
		CartItem cartItem = map.remove(pid);
		this.setTotal(this.getTotal() - cartItem.getSubTotal());
	}
	
	//清空购物车
	public void clearCart() {
		map.clear();
		this.setTotal((double)0);
	}
	
	
}
