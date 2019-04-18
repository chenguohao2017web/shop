package net.shop.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.shop.category.mapper.CategoryMapper;
import net.shop.category.vo.Category;

@Transactional
@Service
public class CategoryService {
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	//查询所有一级分类 
	public List<Category> findAll() {
		return categoryMapper.findAll();
	}
	
	//新增一級分類
	public void add(String name) {
		categoryMapper.add(name);
	}
	
	//根據id刪除一級分類
	public void delByCid(String cid) {
		categoryMapper.delByCid(cid);
	}
	
	//根據id查詢一級分類
	public Category findByCid(String cid) {
		return categoryMapper.findByCid(cid);
	}
	
	//更新一級分類
	public void update(Category category) {
		categoryMapper.update(category);
	}
}
