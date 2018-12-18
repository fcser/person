package cn.java.spring.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
*@author：zym
*@version：
*@time：2018年5月24日下午9:34:04
*/

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("cn.java.spring.study")
public class AopConfig {

	@Bean
	public RoleAspect getRoleAspect() {
		return new RoleAspect();
	}

}
