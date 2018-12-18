package cn.java.personal.service;

import java.util.ArrayList;

import cn.java.personal.pojo.Work;

/**
*@author：zym
*@version：
*@time：2018年6月8日上午12:19:37
*/
public interface WorkService {
	public int insertWork(Work work);
	public int updateWork(Work work);
	public ArrayList<Work> queryWork(int userId);
	public int deleteWorks(int userId);
	public int deleteWork(int id);
}
