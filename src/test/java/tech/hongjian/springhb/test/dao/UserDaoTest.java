package tech.hongjian.springhb.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import tech.hongjian.springhb.config.RootConfig;
import tech.hongjian.springhb.config.WebConfig;
import tech.hongjian.springhb.dao.UserDao;
import tech.hongjian.springhb.entity.User;
import tech.hongjian.springhb.service.UserService;

import java.util.Date;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
@WebAppConfiguration
public class UserDaoTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testFind() {
		assertNotNull(userService.find(1));
	}
	
	
	@Test
	public void testInsert() {
	    for (int i = 0; i < 10; i ++) {
	        User u = new User();
	        u.setAge(20 + (int) Math.random()); 
	        u.setUsername("test" + i);
	        u.setPassword("123");
	        u.setRegistTime(new Date());
			userService.save(u);
	    }
	}
}
