package cn.java.personal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.java.personal.dao.UserMapper;
import cn.java.personal.pojo.User;
import cn.java.personal.service.UserService;
import cn.java.personal.utils.LoginMsg;

/**
*@author：zym
*@version：
*@time：2018年6月4日下午10:11:44
*/
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper=null;
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public String login(String phone,String password) {
		// TODO Auto-generated method stub
		//return false;
		User user=queryUser(phone);
		if(user==null) {
			return LoginMsg.noUser;
		}else if(!user.getPassword().equals(password)) {
			return LoginMsg.wrongPassword;
		}else {
			return LoginMsg.success;
		}
		
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public User queryUser(String phone) {
		// TODO Auto-generated method stub
		System.out.println("我来查数据");
		return userMapper.queryUser(phone);
	}


	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertUser(user);
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public User queryUserbyId(int id) {
		// TODO Auto-generated method stub
		return userMapper.queryUserbyId(id);
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return userMapper.deleteUser(id);
	}

}
