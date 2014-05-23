package com.mypack.hashes;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class HIncrbyService {
	
	
	@Resource(name="redisTemplate")
	private RedisTemplate<String,String> redisTemplate;
	
	public void incr(){
		redisTemplate.<String,Object>opsForHash().put("user", "count", "1");
		redisTemplate.opsForHash().increment("user", "count", 5);
	}
}
