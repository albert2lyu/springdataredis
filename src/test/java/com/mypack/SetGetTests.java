package com.mypack;

import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-redis1.xml")
public class SetGetTests {
	
	
	@Resource(name="redisTemplate")
	private RedisTemplate<String, String>  redisTemplate;
	
	
	public void setTest(){
		
		for(long i = 0; i < 1000000; i++){
			String value = "A" + String.valueOf(i);
			redisTemplate.opsForSet().add("setempi", value);
		}
	}
	
	@Test
	public void test2(){
		long b = System.currentTimeMillis();
		Set<String> setList = redisTemplate.opsForSet().members("setempi");
		for(String i: setList){
			
		}
		long e =System.currentTimeMillis();
		System.out.println((e-b)/1000);
	}
}
