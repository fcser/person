package cn.java.spring.study;

import org.springframework.stereotype.Component;

/**
*@author：zym
*@version:该类会被ioc容器扫描，生成bean
*@time：2018年5月24日下午5:15:27
*/
@Component
public class RoleServiceImpl implements RoleService {

	@Override
	public void printRole(Role role) {
		// TODO Auto-generated method stub

		System.out.println("id="+role.getId()+",name="+role.getRoleName()+",nate="+role.getNote());
	}

}
