package cn.java.personal.service;

import java.util.ArrayList;

import cn.java.personal.pojo.Education;

/**
*@author：zym
*@version：
*@time：2018年6月8日上午12:05:24
*/
public interface EducationService {
    public int insertEducetion(Education  education);
	
	public int updateEducation(Education education);
	
	public ArrayList<Education> queryEducation(int userId);
	
	public int deleteEducations(int userId);
	
	public int deleteEducation(int id);
}
