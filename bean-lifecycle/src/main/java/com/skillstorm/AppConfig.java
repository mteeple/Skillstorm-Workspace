package com.skillstorm;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

@Configuration
@ComponentScan("com.skillstorm")
public class AppConfig {
	public static void main(String[] args) {
		//ApplicationContext  IS-A Beanfactory
		AbstractApplicationContext context =new AnnotationConfigApplicationContext(AppConfig.class);
		context.getBean(SpringBean.class).service();
		//context.getBean(SpringBean.class).service();
		//context.getBean(SpringBean.class).service();
		context.close(); // Normal ApplicationContext doesn't have a close method, AbstractApplicationContext does
	}
	
	@Bean(initMethod = "init", destroyMethod = "destruction")
	public SpringBean springBean() {
		return new SpringBean();
	}
	
}
