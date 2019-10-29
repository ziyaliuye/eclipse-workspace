package cn.cnm;

import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;

public class Test {

	public static void main(String[] args) {
		// 获取 Spring 的最大容器
		ApplicationContext ac = null;
		// 获取地址解析器
		HandlerMapping hm = null;
		// 获取适配器
		HandlerAdapter ha = null;
		// 获取视图解析器
		ViewResolver vr = null;
	}

}
