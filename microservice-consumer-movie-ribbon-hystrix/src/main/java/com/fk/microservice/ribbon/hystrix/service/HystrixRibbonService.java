package com.fk.microservice.ribbon.hystrix.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fk.microservice.ribbon.hystrix.vo.IUserVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HystrixRibbonService {

	@Autowired
	private RestTemplate restTemplate;
		
	private static final Logger LOGGER = LoggerFactory.getLogger(HystrixRibbonService.class);
	/*
	 * 通过@HystrixCommand注解指定该方法发生异常时调用的方法
	 */
	@HystrixCommand(fallbackMethod = "fallback")
	public IUserVO findById(Long id){
		return this.restTemplate.getForObject("http://microservice-provider-user/" + id, IUserVO.class);
	}
	/*
	 * hystrix fallback方法
	 * @Param id
	 * @Return 默认的用户
	 */
	public IUserVO fallback(Long id){
		HystrixRibbonService.LOGGER.info("异常发生。进入到fallback方法，接受的参数：id = {}",id);
		IUserVO user = new IUserVO();
		user.setId(-1l);
		user.setUsername("defalut username");
		user.setAge(0);
		return user;
	}
	
}
