package net.shop.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

import net.shop.order.vo.Order;
import net.shop.order.vo.OrderItem;

public interface OrderMapper {
	
	@Insert("insert into orders(state, ordertime, total, uid) values(#{state}, #{ordertime}, #{total}, #{user.uid})")
	@Options(useGeneratedKeys=true, keyProperty="oid", keyColumn="oid")
	public void save(Order order);
	
	@Insert("<script>" +
			"insert into orderitem(count, subtotal, pid, oid) values" +
			"<foreach collection='orderItems' item='item' separator=','>" +
			"(#{item.count}, #{item.subtotal}, #{item.product.pid}, #{oid})" +
			"</foreach>" +
			"</script>")
	public void saveOrderItem(List<OrderItem> orderItems, Integer oid);
	
	
	//根据oid 更新支付后得状态
	@Update("update orders set name = #{name}, addr = #{addr} where oid = #{oid}")
	public void updateByOid(String oid, String name, String addr);

}
