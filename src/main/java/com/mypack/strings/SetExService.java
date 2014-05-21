package com.mypack.strings;



import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class SetExService {
	
	@Resource(name="stringRedisTemplate")
	private StringRedisTemplate stringRedisTemplate;
	

	public void test(){
		stringRedisTemplate.execute(new Exrc());
	}
	
	
	
	
	private final class Exrc implements RedisCallback<Object>{
		@Override
		public Object doInRedis(RedisConnection rc)
				throws DataAccessException {
			// TODO Auto-generated method stub
			String key ="fuck";
			String value="value";
			rc.setEx(key.getBytes(), 60, value.getBytes());
			return null;
		}
	}

	

}
