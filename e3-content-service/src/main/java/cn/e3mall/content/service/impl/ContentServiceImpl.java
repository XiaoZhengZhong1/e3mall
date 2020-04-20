package cn.e3mall.content.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.e3mall.common.jedis.JedisClient;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.content.service.ContentService;
import cn.e3mall.mapper.TbContentMapper;
import cn.e3mall.pojo.TbContent;
import cn.e3mall.pojo.TbContentExample;
import cn.e3mall.pojo.TbContentExample.Criteria;
@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private TbContentMapper contentMapper ;
	
	//注入redis集群的接口,可使用集群的实现类做缓存
	@Autowired
	private JedisClient jedisClient;
	
	//@Value("${CONTENT_LIST}")
	private String CONTENT_LIST="CONTENT_LIST";
	//页面新增添加内容业务
	@Override
	public E3Result addContent(TbContent tbContent) {
		//因为点击新增时弹框中有内容表中封装的大部分字段内容,没有id 创建时间 和 更新时间 id是自动增长的不要理会
		tbContent.setCreated(new Date());
		tbContent.setUpdated(new Date());
		//把封装完整的内容对象村到数据库内容表中
		contentMapper.insert(tbContent);
		
		//缓存同步,删除缓存中对应的数据。
				jedisClient.hdel(CONTENT_LIST, tbContent.getCategoryId().toString());
		
		return E3Result.ok();
	}
	
	
	//实现e3-protal-web商品首页轮播图从数据库中动态获取
		/*返回结果是一个商品集合LIst<TbContent> 参数是根据商品表中的外键cid ,表示商品表中的内容都是
		 * cid外键表中的大广告的内容*/
	@Override
	public List<TbContent> getContentListByCid(long cid) {
		
		//先查询缓存
				try {
					//如果缓存中有直接响应结果                            把long型的cid转成字符串型加 ""
					String json = jedisClient.hget(CONTENT_LIST, cid + "");
					if (StringUtils.isNotBlank(json)) {
						List<TbContent> list = JsonUtils.jsonToList(json, TbContent.class);
						return list;
					}
				} catch (Exception e) {
					e.printStackTrace();   //表示如果查询缓存有异常只打印,可以去数据库查,不能因为因为查缓存异常而包错
				}
		
		
		//创建商品内容表实例对象
		TbContentExample example = new TbContentExample();
		//获取创建添加对象
		Criteria createCriteria = example.createCriteria();
		/*设置查询条件,表示商品分类表id就是参数中的cid,就是一个类型的所有商品信息的外键cid都是一样的*/
		createCriteria.andCategoryIdEqualTo(cid);
		//返回所有cid相同的商品集合,也就是一个类型的商品
		List<TbContent> list = contentMapper.selectByExampleWithBLOBs(example);
		
		//把结果添加到缓存
				try {
					jedisClient.hset(CONTENT_LIST, cid + "", JsonUtils.objectToJson(list));
				} catch (Exception e) {
					e.printStackTrace();
				}
		
		return list;
	}

}
