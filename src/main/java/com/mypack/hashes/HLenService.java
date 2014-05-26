package com.mypack.hashes;


import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class HLenService {

	@Resource(name="redisTemplate")
	private RedisTemplate<String, String>  redisTemplate;
	
	public void test(){
		redisTemplate.opsForHash().put("key", "a", "avalue");
		redisTemplate.opsForHash().put("key", "b", "bvalue");
		redisTemplate.opsForHash().put("key", "c", "cvalue");
		redisTemplate.opsForHash().put("key", "d", "dvalue");
		Long fileNumber = redisTemplate.execute(new HLenrc());
		System.out.println(fileNumber.longValue());
	}
	
	
	
	private final class HLenrc implements RedisCallback<Long>{
		@Override
		public Long doInRedis(RedisConnection rc)
				throws DataAccessException {
			// TODO Auto-generated method stub
			String key = "key";
			Long fileNumber = rc.hLen(key.getBytes());
			return fileNumber;
		}
	}
}
