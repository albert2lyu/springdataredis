package com.mypack.hashes;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class HDelService {
	@Resource(name="redisTemplate")
	private RedisTemplate<String, String>  redisTemplate;
	
	
	public void del(){
		redisTemplate.opsForHash().put("user:1", "name", "cz");	
		System.out.println("put value[user:1 name cz] ok");
		
		String gValue = redisTemplate.<String,String>opsForHash().get("user:1", "name");
		System.out.println("getvalue [user:1 name] :" + gValue);
	    
		redisTemplate.<String,String>opsForHash().delete("user:1",new Object[]{"name"});
		System.out.println("del value[user:1 name cz] ok");
		
		String dgValue = redisTemplate.<String,String>opsForHash().get("user:1", "name");
		System.out.println("getvalue [user:1 name] :" + dgValue);
	}
	

}
