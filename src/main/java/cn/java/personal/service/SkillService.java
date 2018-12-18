package cn.java.personal.service;

import java.util.ArrayList;

import cn.java.personal.pojo.Skill;

/**
*@author：zym
*@version：
*@time：2018年6月8日上午12:13:29
*/
public interface SkillService {

	public int insertSkill(Skill skill);
	public int updateSkill(Skill skill);
	public ArrayList<Skill> querySkill(int userId);
	public int deleteSkills(int userId);
	public int deleteSkill(int id);
	
}
