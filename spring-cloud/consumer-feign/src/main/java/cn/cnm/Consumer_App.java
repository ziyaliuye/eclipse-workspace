package cn.cnm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
// 需要使用 feign 的包路径， 就是刚才的 能包含刚才编写的 Controller 类 就行 
@EnableFeignClients(basePackages = { "cn.cnm" })
// 将这个包下的需要装配的类，报错注解 @Controller，@Service，@Repository 等等
//@ComponentScan("cn.cnm")
public class Consumer_App {

	public static void main(String[] args) {
		SpringApplication.run(Consumer_App.class, args);
	}

}
