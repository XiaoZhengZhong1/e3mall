package cn.e3mall.service;

import java.util.List;

import cn.e3mall.common.pojo.EasyUITreeNode;

public interface ItemCatService {
	//首页在点击新增按钮后,点击分类按钮,展示出来的商品分类树形结构目录
	List<EasyUITreeNode> getItemCatlist(long parentId);
}
