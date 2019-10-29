package cn.cnm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 表示这是一个 Eureka 的 Server 端
public class EurekaServer_App {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer_App.class, args);
	}

}
