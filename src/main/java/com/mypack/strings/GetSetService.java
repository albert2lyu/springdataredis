package com.mypack.strings;



import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class GetSetService {
	
	@Resource(name="stringRedisTemplate")
	private StringRedisTemplate stringRedisTemplate;
	
		
	public void test(){
		String value = stringRedisTemplate.execute(new GetSetrc());
		System.out.println("init value:"+value);
	}
	
	
	private final class GetSetrc implements RedisCallback<String>{
		@Override
		public String  doInRedis(RedisConnection rc)
				throws DataAccessException {
			// TODO Auto-generated method stub
			String key = "not exists";
			String nValue = "not exists true";
	        byte[] value = rc.getSet(key.getBytes(), nValue.getBytes());
	        String nval = new String(value);
			return nval;
		}
	}


}
