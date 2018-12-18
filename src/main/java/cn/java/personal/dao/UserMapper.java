package cn.java.personal.dao;

import org.springframework.stereotype.Repository;

import cn.java.personal.pojo.User;

/**
*@author：zym
*@version：
*@time：2018年6月3日下午6:08:09
*/
@Repository
public interface UserMapper {

	/**
	 * 用户注册，可以使用user.getId()查询数据库插入后的主键
	 * @param user
	 * @return 
	 */
	public int insertUser(User user);
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	/**
	 * 根据手机号查询用户信息，用于登录
	 * @param phone
	 * @return
	 */
	public User queryUser(String phone);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int deleteUser(int id);
	/**
	 * 根据用户id查询用户
	 */
	public User queryUserbyId(int id);
	
}
