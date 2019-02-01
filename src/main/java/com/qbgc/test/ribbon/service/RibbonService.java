package com.qbgc.test.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

	/**
	 * 这个注解就是对RestTemplate进行装配。
	 * 顺序：启动Ioc时，如果扫描到@Autowired这个注解，就会去找相应的Bean，然后进行装配
	 */
	@Autowired
	private
	RestTemplate restTemplate;

	public String error(){
        return "ribbon断路器告诉你出错了！";
    }

    @HystrixCommand(fallbackMethod = "error")
	public String index(){
		// 本测试重点
		return restTemplate.getForObject("http://QBGC-ADMIN-SERVICE/hi?name=gaochao", String.class);
	}
}
