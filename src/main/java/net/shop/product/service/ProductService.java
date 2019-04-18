package net.shop.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.shop.categorySecond.mapper.CategorySecondMapper;
import net.shop.categorySecond.vo.CategorySecond;
import net.shop.product.mapper.ProductMapper;
import net.shop.product.vo.PageBean;
import net.shop.product.vo.Product;

@Transactional
@Service
public class ProductService {
	@Autowired
	private ProductMapper productMapper;

	// 获取十条热门商品
	public List<Product> findHot() {
		return productMapper.findHot();
	}

	// 获取十条最新商品
	public List<Product> findNew() {
		return productMapper.findNew();
	}

	// 根据id查询商品
	public Product findByPid(String pid) {
		return productMapper.findByPid(pid);
	}

	// 根据一级分类id查询所有的商品
	public PageBean<Product> findProductByCid(String cid, String page) {
		PageBean<Product> pageBean = new PageBean<>();

		// 设置当前页
		pageBean.setPage(Integer.valueOf(page));

		// 设置每页显示的条数
		Integer pageSize = 8;
		pageBean.setPageSize(pageSize);

		// 获取总记录数
		Integer totalCount = productMapper.findProductCountByCid(cid);
		pageBean.setTotalCount(totalCount);

		// 设置总页数
		Integer totalPage = null;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);

		// 设置分页的起始
		Integer Start = (pageBean.getPage() - 1) * pageSize;
		// 根据一级分类的id获取所有的商品
		List<Product> list = productMapper.findProductsByCid(cid, Start, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	// 根据二级分类id 获取所有商品带分页
	public PageBean<Product> findProductByCsid(String csid, String page) {
		PageBean<Product> pageBean = new PageBean<>();

		// 设置当前页
		pageBean.setPage(Integer.valueOf(page));

		// 设置每页显示的条数
		Integer pageSize = 8;
		pageBean.setPageSize(pageSize);

		// 获取总记录数
		Integer totalCount = productMapper.getCountByCsid(csid);
		pageBean.setTotalCount(totalCount);

		// 设置总页数
		Integer totalPage = null;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);

		// 设置分页的起始
		Integer start = (pageBean.getPage() - 1) * pageSize;
		// 根据2级分类的id获取所有的商品
		List<Product> list = productMapper.getProductsByCsid(csid, start, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	public PageBean<Product> findAll(Integer page) {
		PageBean<Product> pageBean = new PageBean<>();
		pageBean.setPage(page);
		pageBean.setPageSize(8);
		Integer totalCount = productMapper.findCount();
		pageBean.setTotalCount(totalCount);
		Integer totalPage = 0;
		if (totalCount % pageBean.getPageSize() == 0) {
			totalPage = totalCount / pageBean.getPageSize();
		} else {
			totalPage = totalCount / pageBean.getPageSize() + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		Integer start = (pageBean.getPage() - 1) * pageBean.getPageSize();
		
		ArrayList<Product> list = productMapper.findAll(start, pageBean.getPageSize());
		pageBean.setList(list);
		return pageBean;
	}

}
