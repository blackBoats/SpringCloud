package com.fk.microservice.consumer.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fk.microservice.consumer.feign.vo.IUserVO;

@RestController
public class FeignController {

	@Autowired
	private UserFeignClient userFeignClient;
	@GetMapping("/feign/{id}")
	public IUserVO findIdFeign(@PathVariable Long id){
		IUserVO user = this.userFeignClient.findIdFeign(id);
		return user;
	}
}
