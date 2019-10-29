package cn.cnm.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DemoController {
	// demo ������ǿ������߼����� ������Ҫ����ָ���������� ��value-ref��
	@RequestMapping("/demo")
	public String demo(@RequestParam(value = "name1", defaultValue = "100") String name,
			@RequestParam(value = "age1", required = true) int age, @RequestParam("hover") ArrayList<String> hover) {
		System.out.println(name);
		System.out.println(age);
		System.out.println(hover);
		return "index.jsp";
	}

	// resustful�������� @RequestMapping��ֵһ��Ҫ���������Ӧ
	// ע���ڽ���ʱ����Ϊ�и�demo2�������ļ��У� ������id�ļ������滹�и�name
	@RequestMapping("demo2/{name}/{age1}")
	// @PathVariable��ʾ��������ȡ demo2/{id}/{name} ���Ӧ���ֵ�ռλ����ֵ
	// Ĭ���ǰ�������ƥ�䣬 ָ���� valueֵ Ϊ age1 ���ʾ��ƥ��ռλ�� age1 ��ֵ�� ��ֵ�������� age
	public String demo2(@PathVariable String name, @PathVariable("age1") int age) {
		System.out.println(name);
		System.out.println(age);
		// ����ָ����ͼʱ���õ�ǰ����·�� /demo2/id/ ��Ѱ����ͼ, ���Է�����ͼʱ���ֱ������Ŀ��Ŀ¼��ʼ��λ��ͼ
		return "/index.jsp";
	}

	@RequestMapping(value = "demo3", produces = "text/html;charset:utf-8")
	public String demo3() {
		System.out.println("demo3...");
		// �ض���demo4��Controller��
		// ǰ���redirect:�����Ĭ�ϵ���ͼ������
		return "redirect:demo4";
	}

	@RequestMapping("demo4")
	public String demo4() {
		System.out.println("demo4...");
		return "redirect:/index.jsp";
	}

	@RequestMapping("download")
	public void download(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("download...");
		// ������Ӧͷ��Ϣ�� �Ը�����ʽ������Ϊ haha.txt ���ļ�
		response.setHeader("Content-Disposition", "attachment;filename=haha.txt");
		// ��ȡ��Ӧ������ֽ������
		ServletOutputStream os = response.getOutputStream();
		// ��ȡָ����Դ�Ĵ��̾���·��
		String path = request.getServletContext().getRealPath("files");
		System.out.println("files�ľ���·����" + path);
		System.out.println("fileName��" + fileName);
		// ��ȡ������ļ�
		File file = new File(path, fileName);
		// ʹ��Apache�ṩ��IO�����࣬ �Զ���������ȡ�ļ�
		byte[] bytes = FileUtils.readFileToByteArray(file);
		// ��ʼ�������д
		os.write(bytes);
		os.flush();
		os.close();
	}

	@RequestMapping("/upload")
	// �����ύ�����Ķ������ļ�SpringMVC�Ὣ���װ��һ��MultipartFile��
	// ������fileҪ�ͱ�ǩnameһ��, ��Ȼ��ֵ������
	public String upload(MultipartFile file) throws IOException {
		// ��ȡ�ϴ����ļ���
		String fileName = file.getOriginalFilename();
		// ��ȡ�ϴ��ļ��ĺ�׺
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		// ʹ��UUID�����ļ�����ֹ֮ǰͬ���ļ����滻
		String uuid = UUID.randomUUID().toString();
		// ʹ��Apache�ṩ���߰����ϴ��ļ����Ƶ�������������ָ��λ��
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File("D:/" + uuid + suffix));
		return "index";
	}

	// demo ������ǿ������߼����� ������Ҫ����ָ���������� ��value-ref��
	@RequestMapping("/demo1")
	public String demo1(Model model) {
		model.addAttribute("hehe", "ɵ��");
		System.out.println("demo1......");
		int i = 5 / 0;
		return "index";
	}

	@RequestMapping("{page}")
	public String jump(@PathVariable("page") String page) {
		return page;
	}
}
