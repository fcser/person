package cn.java.personal.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.java.personal.dao.EducationMapper;
import cn.java.personal.pojo.Education;
import cn.java.personal.service.EducationService;

/**
*@author：zym
*@version：
*@time：2018年6月8日上午12:06:22
*/
@Service
public class EducationServiceImpl implements EducationService {

	@Autowired
	private EducationMapper ep=null;
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int insertEducetion(Education education) {
		// TODO Auto-generated method stub
		return ep.insertEducetion(education);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int updateEducation(Education education) {
		// TODO Auto-generated method stub
		return ep.updateEducation(education);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public ArrayList<Education> queryEducation(int userId) {
		// TODO Auto-generated method stub
		return ep.queryEducation(userId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int deleteEducations(int userId) {
		// TODO Auto-generated method stub
		return ep.deleteEducations(userId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int deleteEducation(int id) {
		// TODO Auto-generated method stub
		return ep.deleteEducation(id);
	}

}
