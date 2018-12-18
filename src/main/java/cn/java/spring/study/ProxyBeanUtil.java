package cn.java.spring.study;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
*@author：zym
*@version：动态代理模式
*@time：2018年5月24日下午4:34:14
*/
public class ProxyBeanUtil implements InvocationHandler {

	private Object obj;//被代理对象
	private Interceptor interceptor=null;//拦截器
	
	//绑定目标对象与代理对象的关系
	public static Object getBean(Object obj,Interceptor interceptor) {
		ProxyBeanUtil _this=new ProxyBeanUtil();//使用当前类为代理方法
		_this.obj=obj;
		_this.interceptor=interceptor;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(), _this);
	}
	//实现代理逻辑
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object retObj=null;
		boolean exceptionFlag=false;
		interceptor.before(obj);
		try {
			retObj=method.invoke(obj, args);//反射原有方法
		}catch(Exception ex) {
			exceptionFlag=true;
		}finally {
			interceptor.after(obj);
		}
		if(exceptionFlag) {
			interceptor.afterThrowing(obj);
		}else {
			interceptor.afterReturned(obj);
		}
		return retObj;
	}

}
