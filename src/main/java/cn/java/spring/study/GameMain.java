package cn.java.spring.study;
/**
*@author：zym
*@version：
*@time：2018年5月24日下午5:14:19
*/
public class GameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RoleService r=new RoleServiceImpl();
		Interceptor i=new RoleInterceptor();
		RoleService proxy=ProxyBeanFactory.getBean(r, i);
		Role role=new Role(1,"haha","xxxxx");
		proxy.printRole(role);
	}

}
