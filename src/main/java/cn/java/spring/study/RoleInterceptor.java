package cn.java.spring.study;
/**
*@author：zym
*@version：
*@time：2018年5月24日下午5:08:25
*/
public class RoleInterceptor implements Interceptor {

	@Override
	public void before(Object obj) {
		// TODO Auto-generated method stub
             System.out.println("准备打印信息");
	}

	@Override
	public void after(Object obj) {
		// TODO Auto-generated method stub
    
		System.out.println("已经打印完成");
	}

	@Override
	public void afterReturned(Object obj) {
		// TODO Auto-generated method stub

		System.out.println("打印一切正常");
	}

	@Override
	public void afterThrowing(Object obj) {
		// TODO Auto-generated method stub

		System.out.println("打印有异常");
	}

}
