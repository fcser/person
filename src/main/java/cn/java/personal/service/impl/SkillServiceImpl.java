package cn.java.personal.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.java.personal.dao.SkillMapper;
import cn.java.personal.pojo.Skill;
import cn.java.personal.service.SkillService;

/**
*@author：zym
*@version：
*@time：2018年6月8日上午12:14:14
*/
@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillMapper sm=null;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int insertSkill(Skill skill) {
		// TODO Auto-generated method stub
		return sm.insertSkill(skill);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int updateSkill(Skill skill) {
		// TODO Auto-generated method stub
		return sm.updateSkill(skill);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public ArrayList<Skill> querySkill(int userId) {
		// TODO Auto-generated method stub
		return sm.querySkill(userId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int deleteSkills(int userId) {
		// TODO Auto-generated method stub
		return sm.deleteSkills(userId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	public int deleteSkill(int id) {
		// TODO Auto-generated method stub
		return sm.deleteSkill(id);
	}

}
