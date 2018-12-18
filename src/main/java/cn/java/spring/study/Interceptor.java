package cn.java.spring.study;
/**
*@author：zym
*@version：
*@time：2018年5月24日下午4:14:43
*/
public interface Interceptor {

	public void before(Object obj);
	
	public void after(Object obj);
	
	public void afterReturned(Object obj);
	
	public void afterThrowing(Object obj);
	
}
