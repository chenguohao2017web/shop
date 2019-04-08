package net.shop.cart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.shop.cart.vo.Cart;
import net.shop.cart.vo.CartItem;
import net.shop.product.service.ProductService;
import net.shop.product.vo.Product;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private ProductService productService;
	
	//添加商品到购物车
	@RequestMapping("/addCart")
	public String addCart(String pid, String count, HttpSession session) {
		//获取购物车对象
		Cart cart = getCart(session);
		//根据id查询商品对象
		Product product = productService.findByPid(pid);
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setCount(Integer.valueOf(count));
		//添加到购物车
		cart.addCartItem(cartItem);
		return "cart";
	}
	
	//清空购物车
	@RequestMapping("/clearCart")
	public String clearCart(HttpSession session) {
		Cart cart = getCart(session);
		cart.clearCart();
		return "cart";
	}
	
	//根据用户id删除购物车商品
	@RequestMapping("/delByPid")
	public String delByPid(String pid, HttpSession session) {
		Cart cart = getCart(session);
		cart.removeCartItem(Integer.valueOf(pid));
		return "cart";
	}
	
	//获取购物车
	private Cart getCart(HttpSession session) {
		Cart mycart = (Cart) session.getAttribute("cart");
		if(mycart == null ) {
			//购物车不存在 直接new创建购物车
			mycart = new Cart();
			session.setAttribute("cart", mycart);
		}
		return mycart;
	}
}
