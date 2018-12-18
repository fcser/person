package cn.java.personal.pojo;
/**
*@author：zym
*@version：
*@time：2018年6月3日下午3:37:04
*/
public class Project {

	private int id;
	private int userId;
	private String pname;
	private String pbegin;
	private String pend;
	private String myWork;
	private String pintro;
	
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
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPbegin() {
		return pbegin;
	}
	public void setPbegin(String pbegin) {
		this.pbegin = pbegin;
	}
	public String getPend() {
		return pend;
	}
	public void setPend(String pend) {
		this.pend = pend;
	}
	public String getMyWork() {
		return myWork;
	}
	public void setMyWork(String myWork) {
		this.myWork = myWork;
	}
	public String getPintro() {
		return pintro;
	}
	public void setPintro(String pintro) {
		this.pintro = pintro;
	}
}
