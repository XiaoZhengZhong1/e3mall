package cn.e3mall.order.pojo;

import java.io.Serializable;
import java.util.List;

import cn.e3mall.pojo.TbOrder;
import cn.e3mall.pojo.TbOrderItem;
import cn.e3mall.pojo.TbOrderShipping;
//封装和页面对应的订单实体类 订单中包括TbOrder商品订单表信息和物流表TbOrderShipping中的信息
public class OrderInfo extends TbOrder implements Serializable {

	private List<TbOrderItem> orderItems;
	private TbOrderShipping orderShipping;
	public List<TbOrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<TbOrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public TbOrderShipping getOrderShipping() {
		return orderShipping;
	}
	public void setOrderShipping(TbOrderShipping orderShipping) {
		this.orderShipping = orderShipping;
	}
	
}
