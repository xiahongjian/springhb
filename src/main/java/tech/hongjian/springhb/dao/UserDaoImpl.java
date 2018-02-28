package tech.hongjian.springhb.dao;

import org.springframework.stereotype.Repository;

import tech.hongjian.springhb.dao.base.BasicDaoImpl;
import tech.hongjian.springhb.entity.User;

@Repository
public class UserDaoImpl extends BasicDaoImpl<User, Integer> implements UserDao{

}
