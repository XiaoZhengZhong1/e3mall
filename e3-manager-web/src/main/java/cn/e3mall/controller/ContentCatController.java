package cn.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentCategoryService;

/*
 * 内容分类管理
 * 
 * */
@Controller
public class ContentCatController {
	

	@Autowired
	private ContentCategoryService contentCategoryService;
	                           //后台页面点击分类管理请求
	@RequestMapping("/content/category/list")
	@ResponseBody
								//保证请求参数中是有值的,名称为id   默认值为0(数据库中parent_id是0表示是根目录)
	public List<EasyUITreeNode> getContentCatList(@RequestParam(name="id", defaultValue="0")Long parentId) {
		List<EasyUITreeNode> list = contentCategoryService.getContentCatList(parentId);
		return list;
		
	}
	
	/**
	 * 添加分类节点
	 */
	@RequestMapping(value="/content/category/create", method=RequestMethod.POST)
	@ResponseBody
	public E3Result createContentCategory(Long parentId, String name) {
		//调用服务添加节点
		E3Result e3Result = contentCategoryService.addContentCategory(parentId, name);
		return e3Result;
	}
	
	
	/*
	 * 删除分类节点
	 * 
	 * */
	@RequestMapping("/content/category/delete")
	@ResponseBody
	public void deleteNode(long id){
		contentCategoryService.deleteNode(id);
	}
	
	/*
	 * 节点重命名
	 * 
	 * */
	@RequestMapping("/content/category/update")
	@ResponseBody
	public void renameNode(long id , String name){
		contentCategoryService.renameNode(id,name);
	}
}
