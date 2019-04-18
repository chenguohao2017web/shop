package net.shop.categorySecond.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.shop.categorySecond.mapper.CategorySecondMapper;
import net.shop.categorySecond.vo.CategorySecond;
import net.shop.product.vo.PageBean;

@Transactional
@Service
public class CategorySecondService {
	@Autowired
	private CategorySecondMapper categorySecondMapper;
	
	//根据一级分类id 查询所有的二级分类
	public List<CategorySecond> findByCid(String cid) {
		// TODO Auto-generated method stub
		return categorySecondMapper.findByCid(cid);
	}
	
	//查询所有的二级分类带分页
	public PageBean<CategorySecond> findAll(String page) {
		PageBean<CategorySecond> pageBean = new PageBean<>();
		pageBean.setPage(Integer.valueOf(page));
		
		Integer pageSize = 8;
		pageBean.setPageSize(pageSize);
		
		//获取总条数
		Long longCount = categorySecondMapper.findCount();
		int totalCount = longCount.intValue();
		pageBean.setTotalCount(totalCount);
		//设置总页数
		Integer totalPage = 0;
		if(totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		Integer start = (pageBean.getPage() - 1) * pageSize;
		//设置返回的集合
		List<CategorySecond> list = categorySecondMapper.findAll(start, pageSize);
		
		pageBean.setList(list);
		return pageBean;
	}
	
	
	
	
	//新增二级分类
	public void add(CategorySecond cs) {
		categorySecondMapper.add(cs);
	}
	
	//查询所有二级分类不带分页
	public List<CategorySecond> findAll() {
		// TODO Auto-generated method stub
		return categorySecondMapper.findAllList();
	}
	
}
