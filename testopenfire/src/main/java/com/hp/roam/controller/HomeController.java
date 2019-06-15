package com.hp.roam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hp.roam.executor.service.ExecutorSercice;
import com.hp.roam.model.Msg;
import com.hp.roam.model.OfUser;
import com.hp.roam.service.OfUserService;

/**
 * @author ck
 * @date 2019年2月28日 上午11:46:14
 */
@Controller
public class HomeController {

	
	@Autowired
	private ExecutorSercice executorSercice;
	
	@Autowired
	private OfUserService ofUserService;
	
	@RequestMapping("/")
	public String index(Model model){
		Msg msg = new Msg("测试标题","测试内容","额外信息，只对管理员显示");
		model.addAttribute("msg", msg);
		return "home";
	}
	
	@RequestMapping("/demo")
	public String demo(){
		return "echartsdemo";
	}
	
	@GetMapping("startTasks")
	public String startTasks(){
//		SysUser user1 = new SysUser();
//		user1.setUsername("admin_pms");
//		user1.setPassword("123");
//		SysUser user2 = new SysUser();
//		user2.setUsername("admin_demo");
//		user2.setPassword("123");
//		List<SysUser> users = new ArrayList<>();
//		users.add(user1);
//		users.add(user2);
		List<OfUser> users = ofUserService.selectAll();
		List<OfUser> users1 = users.subList(3, 10000);
		for (OfUser ofUser : users1) {
			if(ofUser.getUsername().contains("40")){
				ofUser.getUsername().replace("\40", "\\40");
			}
			System.out.println(ofUser.getUsername());
			executorSercice.executeAsyncTask(ofUser);
		}
		return "success";
	}
	@GetMapping("stopTask")
	public String stopTasks(){
//		SysUser user1 = new SysUser();
//		user1.setUsername("admin_pms");
//		user1.setPassword("123");
//		SysUser user2 = new SysUser();
//		user2.setUsername("admin_demo");
//		user2.setPassword("123");
//		List<SysUser> users = new ArrayList<>();
//		users.add(user1);
//		users.add(user2);
		List<OfUser> users = ofUserService.selectAll();
		List<OfUser> users1 = users.subList(3, 50);
		for (OfUser ofUser : users1) {
			if(ofUser.getUsername().contains("40")){
				ofUser.getUsername().replace("\40", "\\40");
			}
			System.out.println(ofUser.getUsername());
			executorSercice.executeAsyncTaskStop(ofUser);
		}
		return "success";
	}
}
