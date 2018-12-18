package cn.java.personal.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.java.personal.dao.ProjectMapper;
import cn.java.personal.pojo.Project;
import cn.java.personal.service.ProjectService;

/**
*@author：zym
*@version：
*@time：2018年6月8日上午12:11:03
*/
@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectMapper pm=null;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int insertProject(Project project) {
		// TODO Auto-generated method stub
		return pm.insertProject(project);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int updateProject(Project project) {
		// TODO Auto-generated method stub
		return pm.updateProject(project);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public ArrayList<Project> queryProject(int userId) {
		// TODO Auto-generated method stub
		return pm.queryProject(userId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int deleteProjects(int userId) {
		// TODO Auto-generated method stub
		return pm.deleteProjects(userId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int deleteProject(int id) {
		// TODO Auto-generated method stub
		return pm.deleteProject(id);
	}

}
