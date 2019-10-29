package cn.cnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.cnm.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("hello")
	public String selectAll(Model model) {
		System.out.println(userService.selectALl());
		model.addAttribute("users", userService.selectALl());
		return "index";
	}
}
