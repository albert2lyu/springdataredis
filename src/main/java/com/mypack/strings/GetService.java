package com.mypack.strings;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class GetService {
	
	@Resource(name="stringRedisTemplate")
	private StringRedisTemplate stringRedisTemplate;
	
	public void get(String key){
		String value = stringRedisTemplate.opsForValue().get(key);
		System.out.println("key:"+key+"---> vlaue:" + value);
	}
}
