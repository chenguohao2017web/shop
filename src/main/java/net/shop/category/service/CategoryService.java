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

	public List<Category> findAll() {
		return categoryMapper.findAll();
	}
}
