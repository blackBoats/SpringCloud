package com.fk.microservice.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fk.microservice.consumer.service.RibbonService;
import com.fk.microservice.consumer.vo.IUserVO;

@RestController
public class RibbonController {

	@Autowired
	private RibbonService ribbonService;
	
	@GetMapping("/ribbon/{id}")
	public IUserVO findIUserVoById(@PathVariable Long id){
		return this.ribbonService.findById(id);
		
	}
	
}
