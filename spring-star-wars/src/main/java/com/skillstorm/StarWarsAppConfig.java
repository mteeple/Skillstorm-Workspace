package com.skillstorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.skillstorm.controller.StormtrooperController;
import com.skillstorm.data.StormtrooperRepository;

@Configuration
@ComponentScan(basePackages = "com.skillstorm") //basePackage- including all subpackages (scanning the package for @Component)
@PropertySource("classpath:application-${spring.profiles.active}.properties") //load these properties into the Environment
public class StarWarsAppConfig {
	//@Autowired // give me my env
	//private Environment env;
	
	public static void main(String[] args) { //ApplicationContext will eagerly load 
		//Beanfactory - does NOT eagerly load singletons though
		ApplicationContext context = new AnnotationConfigApplicationContext(StarWarsAppConfig.class);
		System.out.println(context.getBean(StormtrooperRepository.class).url);
		context.getBean(StormtrooperController.class);
		
	}
	
}
