package net.shop.category.vo;

import java.util.List;
import java.util.Set;

import net.shop.categorySecond.vo.CategorySecond;

public class Category {
	private Integer cid;
	private String cname;
	
	//二级分类集合
	private List<CategorySecond> categoryseconds;
	
	public List<CategorySecond> getCategoryseconds() {
		return categoryseconds;
	}
	public void setCategoryseconds(List<CategorySecond> categoryseconds) {
		this.categoryseconds = categoryseconds;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", categoryseconds=" + categoryseconds + "]";
	}
	
}
