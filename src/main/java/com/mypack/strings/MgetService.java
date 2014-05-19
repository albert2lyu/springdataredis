package com.mypack.strings;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class MgetService {
	
	@Resource(name="stringRedisTemplate")
	private StringRedisTemplate stringRedisTemplate;
	
	
	
	
	public void get(){
		 ValueOperations<String, String> vo = stringRedisTemplate.opsForValue();
		 List<String> cList = new ArrayList<String>();
		 cList.add("1");
		 cList.add("2");
		 List<String> mgetList = vo.multiGet(cList);
		 for(String t : mgetList){
			 System.out.println(t);
		 }
	}

}
