package cn.e3mall.common.pojo;

import java.io.Serializable;

public class EasyUITreeNode implements Serializable {
	//本类用来展示前端菜单中,点击"新增商品"按钮中的"商品类目"按钮下的类目展示,tree树结构展示
	//tree树结构,最顶层的是根节点,最底层的是叶节点.就是目录结构,层级目录结构
	/*展示目录结构的时候异步加载,数据库中id为0是根目录,当点击"新增商品"点击"选择类目"时展示所有
	 * id为0的根目录.并且异步加载所有子目录.子目录在业务逻辑中是默认关闭的,子目录在数据库中有字段
	 * 声明is parent 1为是 0 就不是 不是父节点就是叶子节点,就是最后一层目录*/
	private long id;
	private String text;
	private String state;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
