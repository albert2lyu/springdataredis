package com.mypack.strings;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SetService {
	
	
	@Resource(name="stringRedisTemplate")
	private StringRedisTemplate stringRedisTemplate;
	
	
	public void setValue(String key,String value){
		stringRedisTemplate.opsForValue().set(key, value);
		System.out.println("set key:" + key + " value:" + value);
	}
}
