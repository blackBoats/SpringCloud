package com.fk.microservice.ribbon.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fk.microservice.ribbon.hystrix.service.HystrixRibbonService;
import com.fk.microservice.ribbon.hystrix.vo.IUserVO;


@RestController
public class HystrixRibbonController {

	@Autowired
	private HystrixRibbonService hystrixRibbonService;
	
	@GetMapping("/ribbon/{id}")
	public IUserVO findById(@PathVariable Long id){
		return this.hystrixRibbonService.findById(id);
	}
	
	@GetMapping("/find")
	public String login(){
		return "dsf";
	}
}
