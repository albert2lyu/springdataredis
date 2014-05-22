package com.mypack.hashes;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class HSetService {
	@Resource(name="redisTemplate")
	private RedisTemplate<String, Object>  redisTemplate;
	
	
	public void set(){
		redisTemplate.opsForHash().put("order:1", "userid","1111111");
	}
}
