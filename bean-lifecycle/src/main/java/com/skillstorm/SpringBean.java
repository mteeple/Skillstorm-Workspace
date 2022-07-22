package com.skillstorm;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//@Component
public class SpringBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean  { 
	//AutoCloseable can be used instead of DisposableBean
	//ApplicationContextAware is useful when trying to get prototypeBean
	
	//Can get it's own BeanName, Beanfactory, appcontext
	//"Aware" that it is a springbean and inside an IoC container
	private String beanName;
	private BeanFactory beanFactory;
	private ApplicationContext applicationContext;
	
	//Props are STEP 2
	@Value("hello")
	private String value;
	
	//step2
	//@Autowired
	//private AnotherBean bean; //doesn't need setter
	//uses API called Reflection
	
	//Step 1 -Singleton called only when started (eagerly)
	public SpringBean() {
		System.out.println("Instantiate");
		//your fields haven't been initialized
	}
	
	public void setBeanName(String name) {
		this.beanName =name;
		System.out.println("Populate properties: ");
		System.out.println("BeanNameAware");
	}
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		System.out.println("ApplicationContextAware" );
	}
	
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException { //BeanFactory invokes before ApplicationContextAware always
		this.beanFactory = beanFactory;
		System.out.println("BeanFactoryAware" );
	}
	
	//init
	public void afterPropertiesSet() throws Exception { //Very common to use this
		System.out.println("InitializingBean");
	}
	
	public void init() throws Exception{ //Will invoke after the default init
		System.out.println("Custom init()");
	}
	
	//in service
	public void service() {
		System.out.println("Making a bean..." + this.applicationContext.getBean(AnotherBean.class));
	}
	
	//destroy
	public void destroy() throws Exception{
		System.out.println("DisposableBean");
	}
	
	public void destruction() {
		System.out.println("Custom destroy()");
	}
}

