package net.shop.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.shop.user.service.UserService;
import net.shop.user.vo.User;

@Controller
public class UserContrller {
	@Autowired
	private UserService userService;
	
	// 跳转登录页
	@RequestMapping("/user/loginPage")
	public String loginPage() {
		return "login";
	}
	
	//登录方法
	@RequestMapping("/user/login")
	public String login(User user, ModelMap model, HttpSession session) {
		//根据用户民和密码查询用户
		User existUser = userService.findByUsernameAndPassword(user);
		if(existUser != null) {
			//登录成功
			session.setAttribute("existUser", existUser);
			return "redirect:/";
		}else {
			model.addAttribute("error", "用户名或密码错误");
			return "login";
		}
	}
	
	//退出登录
	@RequestMapping("/user/loginOut")
	public Object loginout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	//跳转注册页面
	@RequestMapping("/user/registerPage")
	public Object registerPage() {
		return "register";
	}
	
	//注册方法
	@RequestMapping("/user/register")
	public String register(User user) {
		ModelMap model = new ModelMap();
		//先判断当前姓名是否能注册
		User existUser = userService.findByUsername(user.getUsername());
		if(existUser!= null) {
			//用户已存在
			model.addAttribute("error", "用户名已存在");
			return "register";
		}else {
			//用户不存在，进行保存
			userService.save(user);
			return "index";
		}
	}
}
