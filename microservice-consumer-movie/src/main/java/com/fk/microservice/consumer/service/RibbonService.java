package com.fk.microservice.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fk.microservice.consumer.vo.IUserVO;

@Service
public class RibbonService {

	@Autowired
	private RestTemplate restTemplate;
	
	public IUserVO findById(Long id){
		return this.restTemplate.getForObject("http://microservice-provider-user/"+id, IUserVO.class);
	}
}
