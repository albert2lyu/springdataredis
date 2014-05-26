package com.mypack.lists;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RPushService {

	@Resource(name="redisTemplate")
	private RedisTemplate<String, String>  redisTemplate;
	
	public void test(){
		String key = "userlistr";
		redisTemplate.opsForList().rightPush(key, "czabc1");
		redisTemplate.opsForList().rightPush(key,  "czabc2");
		redisTemplate.opsForList().rightPush(key,  "czabc3");
		redisTemplate.opsForList().rightPush(key,  "czabc4");
		redisTemplate.opsForList().rightPush(key,  "czabc5");
		redisTemplate.opsForList().rightPush(key,  "czabc6");
		redisTemplate.opsForList().rightPush(key,  "czabc7");
		redisTemplate.opsForList().rightPush(key,  "czabc8");
	}
}
