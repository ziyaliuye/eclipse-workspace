package cn.cnm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy  // 开启Zuulproxy
public class Zuulproxy_App {

	public static void main(String[] args) {
		SpringApplication.run(Zuulproxy_App.class, args);
	}

}
