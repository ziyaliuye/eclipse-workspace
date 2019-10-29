package cn.cnm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import cn.myrule.MyRandomRule;

@SpringBootApplication
@EnableEurekaClient
// 在启动 provider 微服务的时候能加载自定义的 Ribbon 配置类
@RibbonClient(name = "provider", configuration = MyRandomRule.class)
public class Consumer_App {

	public static void main(String[] args) {
		SpringApplication.run(Consumer_App.class, args);
	}

}
