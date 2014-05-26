package com.mypack.hashes;


import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class HSetNxService {

	@Resource(name="redisTemplate")
	private RedisTemplate<String, String>  redisTemplate;
	
	public void test(){
		Boolean setOk = redisTemplate.execute(new HSetNx());
		System.out.println(setOk);
	}
	
	
	
	private final class HSetNx implements RedisCallback<Boolean>{
		@Override
		public Boolean doInRedis(RedisConnection rc)
				throws DataAccessException {
			// TODO Auto-generated method stub
			String key = "key";
			String field = "field";
			String value = "value";
		    return 	rc.hSetNX(key.getBytes(), field.getBytes(), value.getBytes());
		}
	}
}
