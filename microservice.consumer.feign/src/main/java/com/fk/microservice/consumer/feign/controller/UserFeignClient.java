package com.fk.microservice.consumer.feign.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fk.microservice.consumer.feign.vo.IUserVO;
//@FeignClient(name="microservice-provider-user")
@FeignClient(name="microservice-provider-user",fallback=HystrixClientFallback.class)
public interface UserFeignClient {
    
	@RequestMapping("/{id}")
	public IUserVO findIdFeign(@RequestParam("id") Long id);
	
	/*
	 * 这边采取和SpringCloud官方文档相同的做法，将fallback类作为内部类放入Feign的接口中，当然也可以写一个单独的fallback的类
	 */
	
	@Component
	static class HystrixClientFallback implements UserFeignClient{

		private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);
		@Override
		public IUserVO findIdFeign(Long id) {
			HystrixClientFallback.LOGGER.info("异常发生。进入fallback方法。接受的参数Id = {}",id);
			IUserVO user = new IUserVO();
			user.setId(-1l);
			user.setUsername("default username");
			user.setAge(0);
			return user;
		}
		
	}
}
