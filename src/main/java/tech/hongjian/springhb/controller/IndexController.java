package tech.hongjian.springhb.controller;


import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tech.hongjian.springhb.entity.User;
import tech.hongjian.springhb.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@GetMapping(path = {"", "/"})
	public String index() {
		
//		User user = userService.find(1);
//		System.out.println(user);
	    for (int i = 0; i < 10; i ++) {
            User u = new User();
            u.setAge(20 + (int) Math.random()); 
            u.setUsername("test" + i);
            u.setPassword("123");
            u.setRegistTime(new Date());
            userService.save(u);
        }
		return "index";
	}
	
	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		User user = userService.find(1);
		return user.toString();
	}
	
	
	@ResponseBody
	@GetMapping("/list")
	public String list() throws InterruptedException {
//	    Query<User> query = sessionFactory.getCurrentSession().createQuery("from User where", User.class);
//	    List<User> users = query.list();
//	    for (User u : users) {
//	        System.out.println("user: " + u.getId());
//	        Thread.sleep(1000);
//	    }
	    return "done";
	}
	
	@ResponseBody
	@GetMapping("/insert")
	public String insert() {
	    User u = new User();
	    u.setAge(20 + (int) Math.random());
	    u.setUsername("test" + Math.random());
	    u.setRegistTime(new Date());
	    userService.save(u);
	    return "done";
	}
}
