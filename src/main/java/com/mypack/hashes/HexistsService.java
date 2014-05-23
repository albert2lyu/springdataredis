package com.mypack.hashes;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class HexistsService {

	@Resource(name="redisTemplate")
	private RedisTemplate<String, String>  redisTemplate;
	
	public void exists(){
		boolean hasKey = redisTemplate.opsForHash().hasKey("user:1", "name");
		System.out.println("hasKey : " + hasKey);
	}
}
