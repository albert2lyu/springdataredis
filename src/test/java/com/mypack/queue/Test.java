package com.mypack.queue;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

public class Test {

	/**
	 * @param args
	 * @author 陈阵 
	 * @date 2014-5-29 下午1:23:02 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext cpxa = new ClassPathXmlApplicationContext("classpath:applicationContext-redis1.xml");
		StringRedisTemplate srt = cpxa.getBean("stringRedisTemplate", StringRedisTemplate.class);
		T1 t1 = new T1(srt);
		T2 t2 = new T2(srt);
		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t2);
		
		th1.start();
		th2.start();

	}

}
