package com.mypack.strings;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class AppendService {
	
	
	@Resource(name="stringRedisTemplate")
	private StringRedisTemplate stringRedisTemplate;
	
	
	public void test(){
		ValueOperations<String,String> vo  =stringRedisTemplate.opsForValue();
		vo.set("name", "cz");
		System.out.println("name is : cz");
		vo.append("name", "122233");
		System.out.println("new name is :" + vo.get("name"));
	}
}
