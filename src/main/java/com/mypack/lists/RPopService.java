package com.mypack.lists;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RPopService {

	@Resource(name="redisTemplate")
	private RedisTemplate<String, String>  redisTemplate;
	
	public void test(){
		String key = "agelist";

		redisTemplate.opsForList().leftPush(key, "1");
		redisTemplate.opsForList().leftPush(key, "2");
		redisTemplate.opsForList().leftPush(key, "3");
		redisTemplate.opsForList().leftPush(key, "4");
		redisTemplate.opsForList().leftPush(key, "5");
		redisTemplate.opsForList().leftPush(key, "6");
		redisTemplate.opsForList().leftPush(key, "7");
		redisTemplate.opsForList().leftPush(key, "8");
		
		
		String value = redisTemplate.opsForList().rightPop(key);
		System.out.println(value);
	}
}
