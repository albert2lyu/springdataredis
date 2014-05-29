package com.mypack.queue;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-redis1.xml")
public class SetQueueTests {
	
	
	@Resource(name="redisTemplate")
	private RedisTemplate<String, String>  redisTemplate;
	
	
	
	
	@Test
	public void test2(){
		long b = System.currentTimeMillis();
		for(int i = 0 ;i<=1000; i++){
			redisTemplate.opsForList().leftPush("q1","msg:"+i);
		}
		long e =System.currentTimeMillis();
		System.out.println((e-b)/1000);
	}
}
