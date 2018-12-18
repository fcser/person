package cn.java.spring.study;
/**
*@author：zym
*@version：
*@time：2018年5月24日下午4:18:16
*/
public class ProxyBeanFactory {

	@SuppressWarnings("unchecked")
	public static <T> T getBean(T obj,Interceptor interceptor) {
		return (T) ProxyBeanUtil.getBean(obj,interceptor);
	}
}
