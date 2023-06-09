package cn.age.common.utils.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author created by Singer email:singer-coder@qq.com
 * @time 2018/3/9
 * @description Spring Context 工具类
 */
@Component
public class SpringContextHandler implements ApplicationContextAware {

	/**
	  * 注册Spring上下文
	  */
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextHandler.applicationContext = applicationContext;
	}

	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}
	public static <T> T getBean(Class<T> clazz){
		return applicationContext.getBean(clazz);
	}

	public static <T> T getBean(String name, Class<T> requiredType) {
		return applicationContext.getBean(name, requiredType);
	}

	public static boolean containsBean(String name) {
		return applicationContext.containsBean(name);
	}

	public static boolean isSingleton(String name) {
		return applicationContext.isSingleton(name);
	}

	public static Class<?> getType(String name) {
		return applicationContext.getType(name);
	}

}
