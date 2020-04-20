package cn.e3mall.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentCategoryService;
import cn.e3mall.mapper.TbContentCategoryMapper;
import cn.e3mall.pojo.TbContentCategory;
import cn.e3mall.pojo.TbContentCategoryExample;
import cn.e3mall.pojo.TbContentCategoryExample.Criteria;
//内容分类管理实现类
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
			
	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;
	
	@Override
	public List<EasyUITreeNode> getContentCatList(long parentId) {
	
			// 根据parentid查询子节点列表
			TbContentCategoryExample example = new TbContentCategoryExample();
			Criteria criteria = example.createCriteria();
			//设置查询条件
			criteria.andParentIdEqualTo(parentId);
			//执行查询
			List<TbContentCategory> catList = contentCategoryMapper.selectByExample(example);
			//转换成EasyUITreeNode的列表
			List<EasyUITreeNode> nodeList = new ArrayList<>();
			//遍历根据parentId查询的所有内容父类目录
			for (TbContentCategory tbContentCategory : catList) {
				//创建一个目录结构的节点对象,把遍历的每一个父类目录,当作一个节点
				EasyUITreeNode node = new EasyUITreeNode();
				node.setId(tbContentCategory.getId());
				node.setText(tbContentCategory.getName());
				node.setState(tbContentCategory.getIsParent()?"closed":"open");
				//添加到列表
				nodeList.add(node);
			}
			return nodeList;
		}

	//添加内容节点目录
	@Override
	public E3Result addContentCategory(long parentId, String name) {
		//创建一个tb_content_category表对应的pojo对象
				TbContentCategory contentCategory = new TbContentCategory();
				//设置pojo的属性(就是TbContentCategory表中所有列字段属性)
				//表示在页面当前parentId下添加叶子节点(而叶子节点本身的id是自动增长的)
				contentCategory.setParentId(parentId);
				contentCategory.setName(name);
				//1(正常),2(删除)
				contentCategory.setStatus(1);
				//默认排序就是1
				contentCategory.setSortOrder(1);
				//新添加的节点一定是叶子节点
				contentCategory.setIsParent(false);
				//创建时间
				contentCategory.setCreated(new Date());
				//更新时间
				contentCategory.setUpdated(new Date());
				//插入到数据库
				contentCategoryMapper.insert(contentCategory);
				
				/*判断父节点的isparent属性。如果不是true改为true(因为本方法已经在该节点上添加了
				 * 叶子节点)*/
				//根据parentid查询父节点
				TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(parentId);
				if (!parent.getIsParent()) {
					parent.setIsParent(true);
					//更新到数数据库
					contentCategoryMapper.updateByPrimaryKey(parent);
				}
				//返回结果，返回E3Result，包含pojo
				return E3Result.ok(contentCategory);
			}

	
	// 删除分类节点  
	@Override
	public void deleteNode(long id) {
		//先查询该节点是否的父节点,如果是则说明有子节点就不做删除操作
		TbContentCategory selectByPrimaryKey = contentCategoryMapper.selectByPrimaryKey(id);
		if(!selectByPrimaryKey.getIsParent()){
			contentCategoryMapper.deleteByPrimaryKey(id);
			//把该叶子节点的父节点改为叶子节点因为本次删除操作已经把它的叶子节点删除了
			//获取父节点id
			Long parentId = selectByPrimaryKey.getParentId();
			//根据父节点id查询父节点
			TbContentCategory selectByPrimaryKey2 = contentCategoryMapper.selectByPrimaryKey(parentId);
			//把父节点属性改为false表示不是父节点
			selectByPrimaryKey2.setIsParent(false);
			//修改节点的父节点属性后更新
			contentCategoryMapper.updateByPrimaryKey(selectByPrimaryKey2);
		}
		//如果要删除的节点是父节点就结束方法
		return;
		
	}

	
	//节点重命名
	@Override
	public void renameNode(long id, String name) {
		//根据id查询节点
		TbContentCategory selectByPrimaryKey = contentCategoryMapper.selectByPrimaryKey(id);
		//重新设置节点的名称
		selectByPrimaryKey.setName(name);
		//更新到数据库
		contentCategoryMapper.updateByPrimaryKey(selectByPrimaryKey);
		
	}
	}
	


