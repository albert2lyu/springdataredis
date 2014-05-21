package com.mypack.strings;


import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SetRangeService {
	
	@Resource(name="stringRedisTemplate")
	private StringRedisTemplate stringRedisTemplate;
	
	
	
	
	public void test(){
		stringRedisTemplate.execute(new SetRangerc());	
	}
	
	
	private final class SetRangerc implements RedisCallback<String>{
		@Override
		public String  doInRedis(RedisConnection rc)
				throws DataAccessException {
			// TODO Auto-generated method stub
		    String key = "1";
		    rc.setRange(key.getBytes(),"2".getBytes(), 6);
			return null;
		}
	}


}
