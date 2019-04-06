package net.shop.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import net.shop.product.service.ProductService;
import net.shop.product.vo.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/getItemById")
	public String getItembyid(String pid, ModelMap model) {
		Product existProduct = productService.findByPid(pid);
		model.addAttribute("existProduct", existProduct);
		return "item";
	}
}
