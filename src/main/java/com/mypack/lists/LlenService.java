package com.mypack.lists;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class LlenService {

	@Resource(name="redisTemplate")
	private RedisTemplate<String, String>  redisTemplate;
	
	public void test(){
		String key = "userlistsize";

		redisTemplate.opsForList().leftPush(key, "li gang1");
		redisTemplate.opsForList().leftPush(key, "li gang2");
		redisTemplate.opsForList().leftPush(key, "li gang3");
		redisTemplate.opsForList().leftPush(key, "li gang4");
		redisTemplate.opsForList().leftPush(key, "li gang5");
		
		Long size = redisTemplate.opsForList().size(key);
		System.out.println(size);
	}
}
