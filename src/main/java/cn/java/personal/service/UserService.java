package cn.java.personal.service;

import cn.java.personal.pojo.User;

/**
*@author：zym
*@version：
*@time：2018年6月4日下午10:10:02
*/
public interface UserService {

	public String login(String phone,String password);//登录用户
	public int insertUser(User user);//用户注册 
	public int updateUser(User user);
	public User queryUser(String phone);
	public User queryUserbyId(int id);
	public int deleteUser(int id);
}
