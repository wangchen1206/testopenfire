package com.hp.roam;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hp.roam.executor.service.ExecutorSercice;
import com.hp.roam.model.SysUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {

	
	
	
	@Autowired
	private ExecutorSercice executorSercice;
	
	@Test
	public void testExecutorTask(){
		SysUser user1 = new SysUser();
		user1.setUsername("admin_pms");
		user1.setPassword("123");
		SysUser user2 = new SysUser();
		user2.setUsername("test@test.com");
		user2.setPassword("123");
		List<SysUser> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		//executorSercice.executeAsyncTask(user1);
//		for(SysUser user:users){
//		}
//		for (int i = 0; i < 30; i++) {
//			try {
//				executorSercice.testTask1(i);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
	
}
