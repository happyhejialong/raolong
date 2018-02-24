package com.bfwk.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfwk.pojo.User;
import com.bfwk.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	@RequestMapping("/login")
	public String loginUser(String username,String password,Model model,HttpSession session) {
		if(StringUtils.isEmpty(username) | StringUtils.isEmpty(password)) {
			model.addAttribute("errorMsg","用户名密码不为空");
			return "login";
		}
		UsernamePasswordToken token=new UsernamePasswordToken(username,password);
		Subject subject=SecurityUtils.getSubject();
		try {
			subject.login(token);
			User user=(User) subject.getPrincipal();
			session.setAttribute("user", user);
		}catch(Exception e) {
			model.addAttribute("errorMsg","用户名密码输入错误");
			return "login";
		}
		/*User user=userService.findUserByUsernameAndPassword(username,password);
		if(user==null) {
			model.addAttribute("errorMsg","用户名密码输入错误");
			return "login";
		}
		session.setAttribute("user",user);
		return "main";*/
		return "main";
	}
	@RequestMapping("/logout")
	public String logoutUser(HttpSession session) {
		session.invalidate();
		return "login";
	}
}
