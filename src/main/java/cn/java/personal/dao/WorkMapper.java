package cn.java.personal.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import cn.java.personal.pojo.Work;

/**
*@author：zym
*@version：
*@time：2018年6月7日下午4:01:35
*/
@Repository
public interface WorkMapper {

	public int insertWork(Work work);
	public int updateWork(Work work);
	public ArrayList<Work> queryWork(int userId);
	public int deleteWorks(int userId);
	public int deleteWork(int id);
}
