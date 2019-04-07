package net.shop.categorySecond.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.shop.categorySecond.mapper.CategorySecondMapper;
import net.shop.categorySecond.vo.CategorySecond;

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
	
}
