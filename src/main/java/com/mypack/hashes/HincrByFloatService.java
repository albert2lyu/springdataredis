package com.mypack.hashes;


import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class HincrByFloatService {
	
	@Resource(name="redisTemplate")
	private RedisTemplate<String, String>  redisTemplate;
	
	
	public void incr(){
		redisTemplate.opsForHash().put("float", "fn", "23.45");
		double incr =  12.23;
		redisTemplate.opsForHash().increment("float", "fn", incr);
	}
	
	
	

}
