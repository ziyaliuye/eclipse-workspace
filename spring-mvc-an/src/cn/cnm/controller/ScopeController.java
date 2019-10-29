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
	@RequestMapping("scope1") // SpringMVC����ͨ������ֱ�ӻ�ȡ request��response�ȶ���
	// ���ڰ�ȫ�Կ��� SpringMVC ����ֱ��ͨ��������ȡ ServletContext���� ��Ҫ��request�����л�ȡ
	public String demo(HttpServletRequest request, HttpSession session/* , ServletContext app */) {

		request.setAttribute("requestA", "requestA");
		session.setAttribute("sessionA", "sessionA");
		// ServletContext����ֱ�� getServletContext������û��HttpServletContext����
		ServletContext application = request.getServletContext();
		application.setAttribute("applicationA", "applicationA");
		System.out.println("111");
		return "Scope";
	}

	@RequestMapping("scope2")
	// ��Map�����������У� Ȼ���ڷ����ڸ�ֵ��SpringMVC�Ὣmap����Request������
	public String demo2(Map<String, Object> map) {
		map.put("map1", "�Ǻ�");
		map.put("map2", "����");
		System.out.println(map.getClass());
		return "Scope";
	}

	@RequestMapping("scope3")
	// ��Map�����������У� Ȼ���ڷ����ڸ�ֵ��SpringMVC�Ὣmap����Request������
	public String demo3(Model model) {
		model.addAttribute("hehe", "�Ǻ���");
		return "Scope";
	}

	@RequestMapping("scope4")
	// ��Map�����������У� Ȼ���ڷ����ڸ�ֵ��SpringMVC�Ὣmap����Request������
	public ModelAndView demo4() {
		// ʵ����ModelAndView���󣬲��ҵ��ù��췽��ָ��������ͼ��Ҳ����ͨ��setView����ָ����
		ModelAndView mv = new ModelAndView("Scope");
		// �������
		mv.addObject("hehe", "�Ǻ�");
		return mv;
	}
}
