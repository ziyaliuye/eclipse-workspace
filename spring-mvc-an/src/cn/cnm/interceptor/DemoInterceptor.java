package cn.cnm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor implements HandlerInterceptor {
	// 在进入控制器方法之前执行， 如果返回值为 false 则阻止进入控制器
	// Object 就是拦截的控制器（也就是控制器的那个方法）
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		if (arg0 != null && ServletFileUpload.isMultipartContent(arg0)) {
			ServletRequestContext ctx = new ServletRequestContext(arg0);
			long requestSize = ctx.contentLength();
			if (requestSize > 1024) {
				throw new MaxUploadSizeExceededException(1024);
			}
		}
		System.out.println("preHandle....");
		System.out.println("arg2：" + arg2);
		return true;
	}

	// 控制器执行完成， 进入到视图（JSP）之前执行这个方法
	// Object 就是拦截的控制器（也就是控制器的那个方法）
	// ModelAndView 控制器中的属性（必须是Model对象中的属性）和视图信息
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("postHandle....");
		System.out.println("要跳转到的页面：" + arg3.getViewName());
		System.out.println("获取控制器空的model值：" + arg3.getModel().get("hehe"));
	}

	// 视图（JSP）执行完成之后执行这个方法
	// Object 就是拦截的控制器（也就是控制器的那个方法）
	// Exception 记录在执行过中出现的异常， 我们可以将异常记录在日志中
	// 如果Exception对象为 null 则表示执行过程中无异常
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion....");
		System.out.println("执行过程中的异常信息：" + arg3.getMessage());
		arg1.sendRedirect("index");
	}
}
