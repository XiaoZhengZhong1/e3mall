package cn.e3mall.content.service;

import java.util.List;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.utils.E3Result;

//内容分类管理接口
public interface ContentCategoryService {

	//当页面点击内容分类按钮时,没有id时默认展示所有的树结构的父类id
	List<EasyUITreeNode> getContentCatList(long parentId);
	
	//添加内容节点目录
	E3Result addContentCategory(long parentId, String name);

	// 删除分类节点  
	void deleteNode(long id);

	//节点重命名
	void renameNode(long id, String name);
}
