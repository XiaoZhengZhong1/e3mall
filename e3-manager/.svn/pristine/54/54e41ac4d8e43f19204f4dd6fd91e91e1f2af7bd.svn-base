package cn.e3mall.service;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;

public interface ItemService {
	//商品查询,故居商品id查询,测试框架是否搭建成功
	TbItem getItemById(long itemId);
	
	//查询商品,并分页
	EasyUIDataGridResult getItemList(int page , int rows);
	
	//添加商品功能(包括商品图片上传)
	E3Result addItem(TbItem item, String desc);

	
	//删除商品
	void deleteItem(long[] ids);

	//商品下架
	void ItemStatus_lower(long[] ids);

	//商品上架
	void ItemUpStatus(long[] ids);
	
	//根据商品id获取商品描述信息
	TbItemDesc getItemDescById(long itemId);
}
