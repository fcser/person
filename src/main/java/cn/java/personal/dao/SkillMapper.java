package cn.java.personal.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import cn.java.personal.pojo.Skill;

/**
*@author：zym
*@version：
*@time：2018年6月7日下午4:01:20
*/
@Repository
public interface SkillMapper {

	public int insertSkill(Skill skill);
	public int updateSkill(Skill skill);
	public ArrayList<Skill> querySkill(int userId);
	public int deleteSkills(int userId);
	public int deleteSkill(int id);
	
}
