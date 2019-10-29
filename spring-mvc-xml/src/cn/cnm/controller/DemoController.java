package cn.cnm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DemoController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("控制器被访问了");
		// 具备传值和视图功能, 这里在返回后， 视图解析器会做一系列的处理（加前缀后缀等）， 最终拼接一个完成的URI
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
}
