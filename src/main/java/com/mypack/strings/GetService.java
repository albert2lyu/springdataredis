package com.mypack.strings;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;


@Service
public class GetService {
	
	@Resource(name="stringRedisTemplate")
	private StringRedisTemplate stringRedisTemplate;
	
	public void get(){
		ValueOperations<String,String> vp = stringRedisTemplate.opsForValue();
		String key = "name";
		String value = "cz";
		vp.set(key, value);
		System.out.println("set key:"+key+"---> vlaue:" + value);
		String val = stringRedisTemplate.opsForValue().get(key);
		System.out.println("get key:"+key+"---> vlaue:" + val);
	}
}
