package net.shop.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.shop.order.mapper.OrderMapper;
import net.shop.order.vo.Order;
import net.shop.order.vo.OrderItem;

@Transactional
@Service
public class OrderService {
	@Autowired
	private OrderMapper orderMapper;
	
	//保存订单信息
	public void save(Order order) {
		//保存到订单主表
		orderMapper.save(order);
		Integer oid = order.getOid();
		//保存数据到从表
		List<OrderItem> orderItems = order.getOrderItems();
		orderMapper.saveOrderItem(orderItems, oid);
		
		
	}

	public void updateByOid(String oid, String name, String addr) {
		orderMapper.updateByOid(oid,name,addr);
	}

}
