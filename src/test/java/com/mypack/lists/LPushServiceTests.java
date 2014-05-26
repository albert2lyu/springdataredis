package com.mypack.lists;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mypack.lists.LPushService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-redis1.xml")
public class LPushServiceTests {
	
	@Resource
	private LPushService lPushService;
	
	
	@Test
	public void test(){
		lPushService.test();
	}
	

}
