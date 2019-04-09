package net.shop.order.controller;

import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import net.shop.cart.vo.Cart;
import net.shop.cart.vo.CartItem;
import net.shop.order.service.OrderService;
import net.shop.order.vo.Order;
import net.shop.order.vo.OrderItem;
import net.shop.user.vo.User;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	//提交订单
	@RequestMapping("/orderPage")
	public String orderpage(HttpSession session, ModelMap model) {
		//判断用户是否登陆
		User existUser = (User) session.getAttribute("existUser");
		if(existUser == null) {
			//未登陆
			model.addAttribute("error", "请先登陆" );
			return "login";
		}
		
		//已登陆
		//获取购物车内所有的东东
		Cart cart = (Cart) session.getAttribute("cart");
		//创建order对象
		Order order = new Order();
		order.setOrdertime(new Date());
		order.setState(1);
		order.setTotal(cart.getTotal());
		order.setUser(existUser);
		Collection<CartItem> cartItems = cart.getCartItems();
		for (CartItem cartItem : cartItems) {
			OrderItem orderItem = new OrderItem();
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubTotal(cartItem.getSubTotal());
			order.getOrderItems().add(orderItem);
		}
		orderService.save(order);
		model.addAttribute("order", order);
		
		//清空购物车
		cart.clearCart();
		return "order";
	}
	
	//确认订单
	@RequestMapping("/submitOrder")
	public String submitOrder(String name, String addr, String oid) {
		//跳转支付页面
		
		//支付成功后 根据oid更新order信息
		orderService.updateByOid(oid, name, addr);
		
		return "redirect:/";
	}
}
