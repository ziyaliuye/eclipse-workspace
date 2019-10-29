package cn.cnm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer // 开启 ConfigServer 服务端
public class ConfigServer_App {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServer_App.class, args);
	}

}
