package cn.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;

@Controller
public class ItemController {
	//商品查询,故居商品id查询,测试框架是否搭建成功
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")   //{}表示url模板映射,可以从大括号中把值取出来当作参数
	@ResponseBody								//itmId和上面请求参数一样就能映射到,如果不一样就需要value=
	public TbItem getItemById(@PathVariable Long itemId){
		return itemService.getItemById(itemId);
		
	} 
	
	
	//查询商品,并分页
	@RequestMapping("/item/list")
	@ResponseBody
																//页面请求的参数
	public EasyUIDataGridResult getItemList(Integer page , Integer rows ){
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	
	/**
	 * 商品添加功能
	 */
	@RequestMapping(value="/item/save", method=RequestMethod.POST)
	@ResponseBody
	public E3Result addItem(TbItem item, String desc) {
		E3Result result = itemService.addItem(item, desc);
		return result;
	}
	
	//删除商品
//	@RequestMapping("/rest/item/delete")
//	@ResponseBody
//	public String deleteItem(String ids){
////		itemService.deleteItem(ids);
//		String[] idss = ids.split(",");
//		System.out.println(ids.toString());
//		System.out.println();
//		System.out.println();
//		return "";
//	}
	
	
	//删除商品
	@RequestMapping("/rest/item/delete")
	@ResponseBody
	public void deleteItem1(long[] ids){	
		itemService.deleteItem(ids);	
		System.out.println();
		System.out.println();
	}
	
	//商品下架
		@RequestMapping("/rest/item/instock")
		@ResponseBody
		public void ItemStatus_lower(long[] ids){	
			itemService.ItemStatus_lower(ids);	
		}
	
		//商品上架
				@RequestMapping("/rest/item/reshelf")
				//@ResponseBody 没有返回值类型所有页不需要返回json数据类型的注解
				//对于页面的参数ids可以直接获取(注意一定要搞清楚页面参数的数据类型,找var声明的具体类型)
				public void ItemUpStatus(long[] ids){	
					itemService.ItemUpStatus(ids);	
				}
}
