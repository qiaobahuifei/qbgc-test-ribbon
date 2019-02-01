package com.qbgc.test.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 这个测试主要是：
 * 1.使用 ribbon 进行服务间的调用
 * 2.修改端口再次启动微服务就可以有两个服务被启动，从而形成集群
 * 3.@LoadBalanced 开启负载均衡，访问微服务时，会在两个不同端口微服务之间切换
 * 4.启动 Ioc 时，如果扫描到 @Autowired 这个注解，就会去找相应的 Bean ，然后进行装配
 * 5.访问微服务可以通过主机名、ip 地址或者微服务大写名
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableHystrix
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}

