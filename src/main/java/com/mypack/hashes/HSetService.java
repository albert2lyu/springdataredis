package com.mypack.hashes;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class HSetService {
	
	@Resource(name="redisTemplate")
	private RedisTemplate<String, String>  redisTemplate;
	
	
	public void set(){
		redisTemplate.opsForHash().put("user:1", "name", "cz1");
		System.out.println("set [user:1 name cz1] ok");
		HashOperations<String,String,String> ho = redisTemplate.opsForHash();
		String getVal = ho.get("user:1","name");
		System.out.println("get [user:1 name] :" + getVal);
	}
	
}
