package cn.java.personal.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import cn.java.personal.pojo.Project;

/**
*@author：zym
*@version：
*@time：2018年6月7日下午3:57:34
*/
@Repository
public interface ProjectMapper {

	public int insertProject(Project project);
	
	public int updateProject(Project project);
	
	public ArrayList<Project> queryProject(int userId);
	
	public int deleteProjects(int userId);
	
	public int deleteProject(int id);
}
