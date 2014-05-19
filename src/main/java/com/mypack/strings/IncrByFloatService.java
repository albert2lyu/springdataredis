package com.mypack.strings;


import javax.annotation.Resource;

import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class IncrByFloatService {
	
	@Resource(name="stringRedisTemplate")
	private StringRedisTemplate stringRedisTemplate;
	
	
	
	
	public void set(){
		BoundValueOperations<String,String> vo = stringRedisTemplate.boundValueOps("fc");
		vo.set("17.6");
	}

}
