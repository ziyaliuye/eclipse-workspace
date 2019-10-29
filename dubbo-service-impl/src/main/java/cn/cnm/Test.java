package cn.cnm;

import java.io.IOException;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.alibaba.dubbo.container.Main;

public class Test {

	public static void main(String[] args) throws IOException {
		// ClassPathXmlApplicationContext cc = new
		// ClassPathXmlApplicationContext("applicationContext-dubbo.xml");
		// 手动启动Spring容器（Dubbo 容器配置在Spring容器中了相当于也将Dubbo容器动了）
		// 会启动 Dubbo继承了Netty 网络框架
		// cc.start();
		// 让程序阻塞着， 不然访问服务的时候这个又关了， 就访问不到了
		// System.in.read();

		// 推荐使用Dubbo提供的Main运行, 不需要自己再写获取xml的代码
		// 但是这种方式启动需要将配置文件放入到 META-INF\Spring 目录下
		Main.main(args);
	}

}
