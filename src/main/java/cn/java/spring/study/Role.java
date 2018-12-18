package cn.java.spring.study;
/**
*@author：zym
*@version：
*@time：2018年5月24日下午5:03:11
*/
public class Role {

	private int id;
	private String roleName;
	private String note;
	public Role(int id,String roleName,String note) {
		this.id=id;
		this.roleName=roleName;
		this.note=note;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
