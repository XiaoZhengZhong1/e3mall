package cn.e3mall.item.pojo;

import cn.e3mall.pojo.TbItem;
/*本类封装的是首页页面点击商品时,展示商品详情的相关内容.
 * 实现步骤:1 继承商品表通过有参构造初始化商品的相关消息
 * 2 新增一个获取图片的方法,
 * */
public class Item extends TbItem {
	
	public Item(TbItem tbItem) {
		this.setId(tbItem.getId());
		this.setTitle(tbItem.getTitle());
		this.setSellPoint(tbItem.getSellPoint());
		this.setPrice(tbItem.getPrice());
		this.setNum(tbItem.getNum());
		this.setBarcode(tbItem.getBarcode());
		this.setImage(tbItem.getImage());
		this.setCid(tbItem.getCid());
		this.setStatus(tbItem.getStatus());
		this.setCreated(tbItem.getCreated());
		this.setUpdated(tbItem.getUpdated());
	}

	public String[] getImages() {
		String image2 = this.getImage();
		if (image2 != null && !"".equals(image2)) {
			String[] strings = image2.split(",");
			return strings;
		}
		return null;
	}
}
