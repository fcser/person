package cn.java.personal.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import cn.java.personal.pojo.Education;

/**
*@author：zym
*@version：
*@time：2018年6月7日下午3:44:36
*/
@Repository
public interface EducationMapper {

	public int insertEducetion(Education  education);
	
	public int updateEducation(Education education);
	
	public ArrayList<Education> queryEducation(int userId);
	
	public int deleteEducations(int userId);
	
	public int deleteEducation(int id);
	
}
