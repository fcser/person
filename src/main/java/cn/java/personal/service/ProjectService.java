package cn.java.personal.service;

import java.util.ArrayList;

import cn.java.personal.pojo.Project;

/**
*@author：zym
*@version：
*@time：2018年6月8日上午12:09:58
*/
public interface ProjectService {

    public int insertProject(Project project);
	
	public int updateProject(Project project);
	
	public ArrayList<Project> queryProject(int userId);
	
	public int deleteProjects(int userId);
	
	public int deleteProject(int id);
}
