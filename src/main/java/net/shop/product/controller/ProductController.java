package net.shop.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import net.shop.categorySecond.service.CategorySecondService;
import net.shop.product.service.ProductService;
import net.shop.product.vo.PageBean;
import net.shop.product.vo.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategorySecondService categorySecondService;
	
	@RequestMapping("/getItemById")
	public String getItembyid(String pid, ModelMap model) {
		Product existProduct = productService.findByPid(pid);
		model.addAttribute("existProduct", existProduct);
		return "item";
	}
	
	//根据一级分类查询所有
	@RequestMapping("/getProductByCid")
	public String getProductByCid(ModelMap model, String cid, String page) {
		//根据一级分类id查询所有的商品 带分页
		PageBean<Product> pageBean = productService.findProductByCid(cid, page);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("categoryCid", cid);
		return "itemList";
	}
	
	//根据二级分类查询所有商品带分页
	@RequestMapping("/getProductByCsid")
	public String getProductByCsid(ModelMap model, String csid, String page) {
		//根据二级分类id查询所有商品带分页
		PageBean<Product> pageBean = productService.findProductByCsid(csid, page);
		model.addAttribute("pageBean", pageBean);
		return "itemList";
	}
}
