package cn.e3mall.common.pojo;

import java.io.Serializable;
import java.util.List;

public class EasyUIDataGridResult implements Serializable{
	//本类封装页面分页需要的返回参数:total查询的总记录条数,和rows每页显示行数记录数就是商品列表
	
	private Long total;
	private List rows;
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
}
