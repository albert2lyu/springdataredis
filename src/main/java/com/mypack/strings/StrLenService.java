package com.mypack.strings;



import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class StrLenService {
	
	@Resource(name="stringRedisTemplate")
	private StringRedisTemplate stringRedisTemplate;
	
	
	
	
	public void test(){
		Long length = stringRedisTemplate.execute(new StrLenrc());
		System.out.println("####" + length);
	}
	
	
	private final class StrLenrc implements RedisCallback<Long>{
		@Override
		public Long doInRedis(RedisConnection rc)
				throws DataAccessException {
			// TODO Auto-generated method stub
		    String key = "1";
		    Long length =  rc.strLen(key.getBytes());
			return length;
		}
	}

}
