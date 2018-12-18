package cn.java.personal.mybatis.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.java.personal.pojo.User;
import cn.java.personal.service.UserService;
import cn.java.personal.utils.LoginMsg;

/**
*@author：zym
*@version：测试mybatis和spring整合
*@time：2018年6月4日下午10:18:32
*/
public class SpringMybatisMainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		UserService userService=ctx.getBean(UserService.class);
		User user=new User();
		/*user.setName("zzz");
		user.setEducation("本科");
		user.setIntroduce("乐观开朗，积极活泼");
		user.setMail("1243701895@qq.com");
		user.setNation("汉");
		user.setPhone("15858585757");
		user.setSex(0);
		int id=userService.insertUser(user);*/
		user=userService.queryUser("15858585858");
		if(user==null) {
			System.out.println(LoginMsg.noUser);
		}else if(!user.getPassword().equals("123456")) {
			System.out.println(LoginMsg.wrongPassword);
		}else {
			System.out.println(LoginMsg.success);
		}
		System.out.println(user);
	}

}
