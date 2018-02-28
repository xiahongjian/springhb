package tech.hongjian.springhb.test.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import tech.hongjian.springhb.config.RootConfig;
import tech.hongjian.springhb.config.WebConfig;
import tech.hongjian.springhb.dao.UserDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
@WebAppConfiguration
public class UserDaoTest {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testFind() {
		assertNotNull(userDao.find(1));
	}
}
