package com.mypack.hashes;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class HkeyService {

	@Resource(name="redisTemplate")
	private RedisTemplate<String, String>  redisTemplate;
	
	public void test(){
		redisTemplate.opsForHash().put("key", "key1", "value1");
		redisTemplate.opsForHash().put("key", "key2", "value2");
		redisTemplate.opsForHash().put("key", "key3", "value3");
		Set<String> keyFieldList = redisTemplate.<String,String>opsForHash().keys("key");
		for(String i : keyFieldList){
			System.out.println(i);
		}
	}
}
