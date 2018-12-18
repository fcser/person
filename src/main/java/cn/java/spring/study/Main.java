package cn.java.spring.study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.*;
/**
*@author：zym
*@version：
*@time：2018年5月24日下午9:56:43
*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctxx=new AnnotationConfigApplicationContext(AopConfig.class);
		RoleService r=(RoleService)ctxx.getBean(RoleService.class);//生成代理对象
		Role role=new Role(1,"hhh","zzzzz");
		r.printRole(role);
	}

}
