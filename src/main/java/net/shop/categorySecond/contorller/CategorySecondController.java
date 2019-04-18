package net.shop.categorySecond.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.shop.category.service.CategoryService;
import net.shop.category.vo.Category;
import net.shop.categorySecond.service.CategorySecondService;
import net.shop.categorySecond.vo.CategorySecond;
import net.shop.product.vo.PageBean;

@Controller
@RequestMapping("/admin")
public class CategorySecondController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategorySecondService categorySecondService;
	
	//查询所有
	@RequestMapping("/categorySecond/findAll")
	public String categorysecondfindall(Model model,  
										@RequestParam(defaultValue = "1") String page) {
		PageBean<CategorySecond> pageBean = categorySecondService.findAll(page);
		model.addAttribute("pageBean", pageBean);
		return "admin/categorySecond/list";
	}
	
	//新增二级分类 跳转新增页面
	@GetMapping("/categorySecond/addPage")
	public String addPage(Model model) {
		//返回所有的一級分類列表
		model.addAttribute("categoryList", categoryService.findAll());
		return "admin/categorySecond/add";
	}
	
	//新增二級分類方法
	/**
	 * @param model
	 * @param category
	 * @param categorySecond
	 * @return
	 */
	@GetMapping("/categorySecond/add")
	public String add(Model model, Integer category, String categorySecond) {
		//调用插入方法
		Category c = new Category();
		c.setCid(category);
		CategorySecond cs = new CategorySecond();
		cs.setCsname(categorySecond);
		cs.setCategory(c);
		categorySecondService.add(cs);
		return "redirect:/admin/categorySecond/findAll";
	}
}
