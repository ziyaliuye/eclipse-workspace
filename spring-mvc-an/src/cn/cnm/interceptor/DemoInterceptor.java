package cn.cnm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor implements HandlerInterceptor {
	// �ڽ������������֮ǰִ�У� �������ֵΪ false ����ֹ���������
	// Object �������صĿ�������Ҳ���ǿ��������Ǹ�������
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
		System.out.println("arg2��" + arg2);
		return true;
	}

	// ������ִ����ɣ� ���뵽��ͼ��JSP��֮ǰִ���������
	// Object �������صĿ�������Ҳ���ǿ��������Ǹ�������
	// ModelAndView �������е����ԣ�������Model�����е����ԣ�����ͼ��Ϣ
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("postHandle....");
		System.out.println("Ҫ��ת����ҳ�棺" + arg3.getViewName());
		System.out.println("��ȡ�������յ�modelֵ��" + arg3.getModel().get("hehe"));
	}

	// ��ͼ��JSP��ִ�����֮��ִ���������
	// Object �������صĿ�������Ҳ���ǿ��������Ǹ�������
	// Exception ��¼��ִ�й��г��ֵ��쳣�� ���ǿ��Խ��쳣��¼����־��
	// ���Exception����Ϊ null ���ʾִ�й��������쳣
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion....");
		System.out.println("ִ�й����е��쳣��Ϣ��" + arg3.getMessage());
		arg1.sendRedirect("index");
	}
}
