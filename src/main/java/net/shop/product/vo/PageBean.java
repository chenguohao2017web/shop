package net.shop.product.vo;

import java.util.List;
import java.util.Set;

public class PageBean<T> {
	private Integer page;//当前页
	private  Integer totalCount; //数据总数
	private Integer totalPage; //总页数
	private Integer pageSize; //每页显示多少条数据
	private List<T> list; //每页显示数据的集合
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
