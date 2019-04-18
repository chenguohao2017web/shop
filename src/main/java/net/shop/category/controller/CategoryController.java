package net.shop.category.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import net.shop.category.service.CategoryService;
import net.shop.category.vo.Category;

@Controller
@RequestMapping("/admin")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//查詢所有的一級分類
	@RequestMapping("/category/findAll")
	public String findall(ModelMap model) {
		model.addAttribute("list", categoryService.findAll());
		return "admin/category/list";
	}
	
	//跳轉新增
	@RequestMapping("/category/addPage")
	public String categoryaddPage() {
		return "admin/category/add";
	}
	
	//新增一級分類
	@RequestMapping("/category/add")
	public String categoryadd(String name) {
		categoryService.add(name);
		return "redirect:/admin/category/findAll";
	}
	
	//刪除一級分類
	@RequestMapping("/category/delByCid")
	public String categoryDelbyid(String cid) {
		categoryService.delByCid(cid);
		return "redirect:/admin/category/findAll";
	}
	
	//編輯一級分類跳轉
	@RequestMapping("/category/editPage")
	public String categoryEditpage(String cid, ModelMap model) {
		model.addAttribute("category", categoryService.findByCid(cid));
		return "admin/category/edit";
	}
	
	//更新一級分類
	@RequestMapping("/category/update")
	public String categoryupdate(Category category) {
		categoryService.update(category);
		return "redirect:/admin/category/findAll";
	}
}
