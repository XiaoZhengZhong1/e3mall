package cn.e3mall.content.service;

import java.util.List;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbContent;

public interface ContentService {
	//页面新增添加内容业务
	E3Result addContent(TbContent tbContent);
	
	//实现e3-protal-web商品首页轮播图从数据库中动态获取
	/*返回结果是一个商品集合LIst<TbContent> 参数是根据商品表中的外键cid ,表示商品表中的内容都是
	 * cid外键表中的大广告的内容*/
	List<TbContent> getContentListByCid(long cid);
}
