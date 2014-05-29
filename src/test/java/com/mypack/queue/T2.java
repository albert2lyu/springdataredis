package com.mypack.queue;

import org.springframework.data.redis.core.RedisTemplate;

public class T2 implements Runnable {

	private RedisTemplate<String, String>  redisTemplate;
	
	public static int num= 0;
	
	public T2(RedisTemplate<String, String> redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
		  String value = redisTemplate.opsForList().rightPop("q1");
		  if(value == null){
			  break;
		  }
		  System.out.println(value);
		  num ++;
		}
		System.out.println("T2:" + num);
	}

}
