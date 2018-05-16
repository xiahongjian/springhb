package tech.hongjian.springhb.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tech.hongjian.springhb.dao.UserDao;
import tech.hongjian.springhb.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	public User find(Integer id) {
		return userDao.find(id);	
	}
	
	@Transactional
	public void save(User user) {
	    userDao.save(user);
	}
}
