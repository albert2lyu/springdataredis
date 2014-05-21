package com.mypack.strings;



import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class GetRangeService {
	
	@Resource(name="stringRedisTemplate")
	private StringRedisTemplate stringRedisTemplate;
	
		
	public void test(){
		String value = stringRedisTemplate.execute(new Rangerc());
		System.out.println(value);
	}
	
	
	private final class Rangerc implements RedisCallback<String>{
		@Override
		public String  doInRedis(RedisConnection rc)
				throws DataAccessException {
			// TODO Auto-generated method stub
		    String rangeValue =	new String(rc.getRange("abc".getBytes(), 1, 3));
			return rangeValue;
		}
	}


}
