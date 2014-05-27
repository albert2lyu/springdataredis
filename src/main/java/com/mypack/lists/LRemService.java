package com.mypack.lists;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class LRemService {

	@Resource(name = "redisTemplate")
	private RedisTemplate<String, String> redisTemplate;

	public void test() {
		String key = "userlistrem";

		redisTemplate.opsForList().leftPush(key, "li gang1");
		redisTemplate.opsForList().leftPush(key, "li gang1");
		redisTemplate.opsForList().leftPush(key, "li gang1");
		redisTemplate.opsForList().leftPush(key, "li gang2");
		redisTemplate.opsForList().leftPush(key, "li gang3");
		redisTemplate.execute(new LRemrc());

	}

	private final class LRemrc implements RedisCallback<String> {
		@Override
		public String  doInRedis(RedisConnection rc)
				throws DataAccessException {
			// TODO Auto-generated method stub
			String key = "userlistrem";
			rc.lRem(key.getBytes(), 2L, "li gang1".getBytes());
			return null;
		}
	}
}
