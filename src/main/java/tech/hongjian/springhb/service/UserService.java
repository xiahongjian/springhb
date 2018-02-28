package tech.hongjian.springhb.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.hongjian.springhb.dao.UserDao;
import tech.hongjian.springhb.entity.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User find(Integer id) {
		return userDao.find(id);	
	}
}
