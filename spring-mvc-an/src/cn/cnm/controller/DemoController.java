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
	// demo 这里就是控制器逻辑名， 不再需要额外指定控制器名 （value-ref）
	@RequestMapping("/demo")
	public String demo(@RequestParam(value = "name1", defaultValue = "100") String name,
			@RequestParam(value = "age1", required = true) int age, @RequestParam("hover") ArrayList<String> hover) {
		System.out.println(name);
		System.out.println(age);
		System.out.println(hover);
		return "index.jsp";
	}

	// resustful风格解析， @RequestMapping的值一定要和请求相对应
	// 注意在解析时会认为有个demo2的虚拟文件夹， 下面有id文件夹下面还有个name
	@RequestMapping("demo2/{name}/{age1}")
	// @PathVariable表示按参数名取 demo2/{id}/{name} 里对应名字的占位符的值
	// 默认是按参数名匹配， 指定了 value值 为 age1 则表示用匹配占位符 age1 的值， 将值赋给参数 age
	public String demo2(@PathVariable String name, @PathVariable("age1") int age) {
		System.out.println(name);
		System.out.println(age);
		// 返回指定视图时会用当前虚拟路径 /demo2/id/ 来寻找视图, 所以返回视图时最好直接以项目根目录开始定位视图
		return "/index.jsp";
	}

	@RequestMapping(value = "demo3", produces = "text/html;charset:utf-8")
	public String demo3() {
		System.out.println("demo3...");
		// 重定向到demo4的Controller上
		// 前面带redirect:则会走默认的视图解析器
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
		// 设置响应头信息， 以附件形式下载名为 haha.txt 的文件
		response.setHeader("Content-Disposition", "attachment;filename=haha.txt");
		// 获取响应对象的字节输出流
		ServletOutputStream os = response.getOutputStream();
		// 获取指定资源的磁盘绝对路径
		String path = request.getServletContext().getRealPath("files");
		System.out.println("files的绝对路径：" + path);
		System.out.println("fileName：" + fileName);
		// 获取到这个文件
		File file = new File(path, fileName);
		// 使用Apache提供的IO工具类， 以二进制流读取文件
		byte[] bytes = FileUtils.readFileToByteArray(file);
		// 开始往浏览器写
		os.write(bytes);
		os.flush();
		os.close();
	}

	@RequestMapping("/upload")
	// 表单中提交过来的二进制文件SpringMVC会将其封装成一个MultipartFile类
	// 参数名file要和标签name一致, 不然传值不进来
	public String upload(MultipartFile file) throws IOException {
		// 获取上传的文件名
		String fileName = file.getOriginalFilename();
		// 获取上传文件的后缀
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		// 使用UUID命名文件名防止之前同名文件被替换
		String uuid = UUID.randomUUID().toString();
		// 使用Apache提供工具包将上传文件复制到服务器磁盘中指定位置
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File("D:/" + uuid + suffix));
		return "index";
	}

	// demo 这里就是控制器逻辑名， 不再需要额外指定控制器名 （value-ref）
	@RequestMapping("/demo1")
	public String demo1(Model model) {
		model.addAttribute("hehe", "傻逼");
		System.out.println("demo1......");
		int i = 5 / 0;
		return "index";
	}

	@RequestMapping("{page}")
	public String jump(@PathVariable("page") String page) {
		return page;
	}
}
