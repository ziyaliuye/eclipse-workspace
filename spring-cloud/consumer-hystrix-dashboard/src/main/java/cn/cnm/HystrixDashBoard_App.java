package cn.cnm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard // 开启Hystrix仪表盘
public class HystrixDashBoard_App {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashBoard_App.class, args);
	}

}
