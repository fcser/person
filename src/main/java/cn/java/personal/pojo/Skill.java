package cn.java.personal.pojo;
/**
*@author：zym
*@version：
*@time：2018年6月3日下午3:22:51
*/
public class Skill {

	private int id;
	private int userId;//外键
	private String skill;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
}
