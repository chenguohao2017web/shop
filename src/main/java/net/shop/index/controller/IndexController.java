package net.shop.index.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import net.shop.category.service.CategoryService;
import net.shop.category.vo.Category;
import net.shop.product.service.ProductService;
import net.shop.product.vo.Product;

@Controller
public class IndexController {
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public String index(HttpSession session, ModelMap model) {
		//获取一级分类的数据
		List<Category> cList = categoryService.findAll();
		//将一级分类添加到session中
		session.setAttribute("cList", cList);
		
		//获取热门商品十条记录
		List<Product> hList = productService.findHot();
		model.addAttribute("hList", hList);
		
		//获取最新商品十条记录
		List<Product> nList = productService.findNew();
		model.addAttribute("nList", nList);
		//跳转首页
		return "index";
	}
}
