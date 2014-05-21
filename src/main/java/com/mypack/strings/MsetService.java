package com.mypack.strings;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class MsetService {
	
	@Resource(name="stringRedisTemplate")
	private StringRedisTemplate stringRedisTemplate;
	
	
	
	
	public void test(){
		ValueOperations<String, String> vo = stringRedisTemplate.opsForValue();
		Map<String,String> insertMap = new HashMap<String, String>();
		insertMap.put("map1", "value1");
		insertMap.put("map2", "value2");
		insertMap.put("map3", "value3");
		vo.multiSet(insertMap);
	}

}
