package cn.cnm.controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScopeController {
	@RequestMapping("scope1") // SpringMVC可以通过参数直接获取 request、response等对象
	// 出于安全性考虑 SpringMVC 不能直接通过参数获取 ServletContext对象， 需要从request对象中获取
	public String demo(HttpServletRequest request, HttpSession session/* , ServletContext app */) {

		request.setAttribute("requestA", "requestA");
		session.setAttribute("sessionA", "sessionA");
		// ServletContext不能直接 getServletContext（这里没有HttpServletContext对象）
		ServletContext application = request.getServletContext();
		application.setAttribute("applicationA", "applicationA");
		System.out.println("111");
		return "Scope";
	}

	@RequestMapping("scope2")
	// 将Map对象放入参数中， 然后在方法内赋值，SpringMVC会将map放入Request对象中
	public String demo2(Map<String, Object> map) {
		map.put("map1", "呵呵");
		map.put("map2", "哈哈");
		System.out.println(map.getClass());
		return "Scope";
	}

	@RequestMapping("scope3")
	// 将Map对象放入参数中， 然后在方法内赋值，SpringMVC会将map放入Request对象中
	public String demo3(Model model) {
		model.addAttribute("hehe", "呵呵哒");
		return "Scope";
	}

	@RequestMapping("scope4")
	// 将Map对象放入参数中， 然后在方法内赋值，SpringMVC会将map放入Request对象中
	public ModelAndView demo4() {
		// 实例化ModelAndView对象，并且调用构造方法指定返回视图（也可以通过setView方法指定）
		ModelAndView mv = new ModelAndView("Scope");
		// 添加属性
		mv.addObject("hehe", "呵呵");
		return mv;
	}
}
