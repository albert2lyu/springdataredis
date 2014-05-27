package com.mypack.lists;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class LSetService {

	@Resource(name="redisTemplate")
	private RedisTemplate<String, String>  redisTemplate;
	
	public void test(){
		String key = "userlistset";

		redisTemplate.opsForList().leftPush(key, "li gang1");
		redisTemplate.opsForList().leftPush(key, "li gang2");
		redisTemplate.opsForList().leftPush(key, "li gang3");
		redisTemplate.opsForList().leftPush(key, "li gang4");
		redisTemplate.opsForList().leftPush(key, "li gang5");
		
		redisTemplate.execute(new LSetrc());
	}
	
	
	
	private final class LSetrc implements RedisCallback<String> {
		@Override
		public String  doInRedis(RedisConnection rc)
				throws DataAccessException {
			// TODO Auto-generated method stub
			String key = "userlistset";
		    rc.lSet(key.getBytes(), 0L , "lset0".getBytes());
			return null;
		}
	}
}
