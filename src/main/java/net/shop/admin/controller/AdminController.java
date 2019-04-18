package net.shop.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import net.shop.admin.service.AdminService;
import net.shop.admin.vo.AdminUser;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	//跳转登陆页
	@RequestMapping("/login")
	public String adminLogin() {
		return "admin/login";
	}
	
	//登陆方法
	@RequestMapping("/loginFun")
	public String loginfun(String username, String password, ModelMap model, HttpSession session) {
		AdminUser existUser = adminService.findByUsernameAndPassword(username, password);
		if(existUser == null) {
			model.addAttribute("error", "用户名或密码错误");
			return "admin/login";
		}
		session.setAttribute("existUser", existUser);
		return "admin/home";
	}
	
	//推出登陸
	@RequestMapping("/loginOut")
	public String loginout(HttpSession session) {
		session.invalidate();
		return "admin/login";
	}
}
