package com.mypack.hashes;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class HMsetService {
	
	@Resource(name="redisTemplate")
	private RedisTemplate<String, String>  redisTemplate;
	
	
	public void set(){
		redisTemplate.execute(new Msetrc());
	}
	
	public void get(){
		List<String> fieldList = new ArrayList<String>();
		fieldList.add("1");
		fieldList.add("2");
		fieldList.add("3");
		fieldList.add("4");
		
	    List<String> hmgetValueList = redisTemplate.<String,String>opsForHash().multiGet("mest", fieldList);
	    for(String out : hmgetValueList){
	    	System.out.println(out);
	    }
	}
	
	
	private final class Msetrc implements RedisCallback<String>{
		@Override
		public String doInRedis(RedisConnection rc)
				throws DataAccessException {
			// TODO Auto-generated method stub
			String key ="mest";
			Map<byte[],byte[]> map = new HashMap<byte[], byte[]>();
			map.put("1".getBytes(),"1value".getBytes());
			map.put("2".getBytes(),"2value".getBytes());
			map.put("3".getBytes(),"3value".getBytes());
			map.put("4".getBytes(),"4value".getBytes());
			
			rc.hMSet(key.getBytes(), map);
			return "ok";
		}
	}
	

}
