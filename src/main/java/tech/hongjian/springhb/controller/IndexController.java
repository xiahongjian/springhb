package tech.hongjian.springhb.controller;

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

	@GetMapping(path = {"", "/"})
	public String index() {
		
		User user = userService.find(1);
		System.out.println(user);
		
		return "index";
	}
	
	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		User user = userService.find(1);
		return user.toString();
	}
}
