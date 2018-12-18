package cn.java.spring.study;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
*@author：zym
*@version：aop切面,aspect注解告诉ioc这是spring的切面
*@time：2018年5月24日下午9:20:52
*/

@Aspect
public class RoleAspect {
	
	@Before("execution(* cn.java.spring.study.RoleServiceImpl.printRole(..))")
	public void before(Object obj) {
		// TODO Auto-generated method stub
             System.out.println("准备打印信息");
	}
	@After("execution(* cn.java.spring.study.RoleServiceImpl.printRole(..))")
	public void after(Object obj) {
		// TODO Auto-generated method stub
    
		System.out.println("已经打印完成");
	}
	@AfterReturning("execution(* cn.java.spring.study.RoleServiceImpl.printRole(..))")
	public void afterReturned(Object obj) {
		// TODO Auto-generated method stub

		System.out.println("打印一切正常");
	}
	@AfterThrowing("execution(* cn.java.spring.study.RoleServiceImpl.printRole(..))")
	public void afterThrowing(Object obj) {
		// TODO Auto-generated method stub

		System.out.println("打印有异常");
	}
}
