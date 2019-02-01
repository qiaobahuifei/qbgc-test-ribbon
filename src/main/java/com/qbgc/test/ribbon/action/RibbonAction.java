package com.qbgc.test.ribbon.action;

import com.qbgc.test.ribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonAction {

	/**
	 * 这个注解的意思就是给其进行注解，就是赋值或其他操作
	 */
	@Autowired
	private
	RibbonService service;

	@GetMapping("/ribbon")
	public String getRibbonInfo() {
		return service.index();
	}
}
