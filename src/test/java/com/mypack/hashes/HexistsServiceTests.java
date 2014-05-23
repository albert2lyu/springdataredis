package com.mypack.hashes;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-redis1.xml")
public class HexistsServiceTests {
	
	@Resource
	private HexistsService hexistsService;
	
	
	@Test
	public void test(){
		hexistsService.exists();
	}
	

}
