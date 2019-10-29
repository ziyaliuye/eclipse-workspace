package cn.cnm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker  // 启动 Hystrix 的熔断机制( CircuitBreaker)
public class ProviderHystrix_App {
	public static void main(String[] args) {
		SpringApplication.run(ProviderHystrix_App.class, args);
	}
}
