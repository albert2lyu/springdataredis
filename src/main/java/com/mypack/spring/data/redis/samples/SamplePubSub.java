package com.mypack.spring.data.redis.samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SamplePubSub {
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@RequestMapping("/pub")
	public void pub(){
		redisTemplate.convertAndSend("add", "i will kill you");
	}
}
