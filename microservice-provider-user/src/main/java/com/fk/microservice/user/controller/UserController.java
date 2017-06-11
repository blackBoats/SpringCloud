package com.fk.microservice.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fk.microservice.user.dao.UserDao;
import com.fk.microservice.user.vo.IUserVO;

@RestController
public class UserController {

	@Autowired
	private UserDao userDao;
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/{id}")
	public IUserVO findById(@PathVariable Long id){
		IUserVO user = userDao.findOne(id);
		return user;
	}
	
	@GetMapping("/instance-info")
	public ServiceInstance showInfo(){
		ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
		return serviceInstance;
	}
}
