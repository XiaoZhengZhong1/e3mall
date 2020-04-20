package cn.e3mall.cart.service;

import java.util.List;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbItem;

public interface CartService {

	//向redis数据库中添加购物车
	E3Result addCart(long userId, long itemId, int num);
	
	//合并cookie中和redis服务器中的购物车
	E3Result mergeCart(long userId, List<TbItem> itemList);
	
	//获取合并后的购物车列表
	List<TbItem> getCartList(long userId);
	
	//更新购物车商品数量
	E3Result updateCartNum(long userId, long itemId, int num);
	
	//删除购物车商品
	E3Result deleteCartItem(long userId, long itemId);
	
	//提交订单后清空购物车
	E3Result clearCartItem(long userId);
}
