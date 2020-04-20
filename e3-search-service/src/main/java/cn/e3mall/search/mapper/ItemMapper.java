package cn.e3mall.search.mapper;

import java.util.List;

import cn.e3mall.common.pojo.SearchItem;

public interface ItemMapper {
	
	//使用solr服务器查询搜索查询,所有商品列表
	List<SearchItem> getItemList();
	
	//根据搜索商品的id获取搜索商品
	SearchItem getItemById(long itemId);
}
