package com.mypack.hashes;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class HvalsService {
	
	@Resource(name="redisTemplate")
	private RedisTemplate<String, String>  redisTemplate;
	
	
	public void getVals(){
		String[] sResult = redisTemplate.execute(new Hvalsrc());
		for(String temp : sResult){
			System.out.println("######" + temp);
		}
	}
	
	
	
	private final class Hvalsrc implements RedisCallback<String[]>{
		@Override
		public String[]  doInRedis(RedisConnection rc)
				throws DataAccessException {
			// TODO Auto-generated method stub
			 String key = "user:111111";
		     List<byte[]> byteList = rc.hVals(key.getBytes());
		     String[] result = new String[byteList.size()];
		     for(int i = 0 ;i<byteList.size(); i++){
		    	 result[i] = new String(byteList.get(i));
		     }
		     return result;
		}
	}
}
