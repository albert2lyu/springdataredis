package com.mypack.hashes;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class HGetAllService {

	@Resource(name="redisTemplate")
	private RedisTemplate<String, String>  redisTemplate;
	
	public void test(){
		redisTemplate.opsForHash().put("key", "a", "avalue");
		redisTemplate.opsForHash().put("key", "b", "bvalue");
		redisTemplate.opsForHash().put("key", "c", "cvalue");
		redisTemplate.opsForHash().put("key", "d", "dvalue");
		Map<byte[],byte[]> rsMap = redisTemplate.execute(new HGetAllrc());
		for(Map.Entry<byte[], byte[]> entry: rsMap.entrySet()){
			String key = new String(entry.getKey());
			String value = new String(entry.getValue());
			System.out.println("key:" + key + "#####" + "value:" + value);
		}
	}
	
	
	
	private final class HGetAllrc implements RedisCallback<Map<byte[],byte[]>>{
		@Override
		public Map<byte[],byte[]> doInRedis(RedisConnection rc)
				throws DataAccessException {
			// TODO Auto-generated method stub
			String key = "key";
			Map<byte[],byte[]> rsMap= rc.hGetAll(key.getBytes());
			return rsMap;
		}
	}
}
