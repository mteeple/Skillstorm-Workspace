package com.skillstorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.skillstorm.beans.Expense;
import com.skillstorm.controllers.ExpenseController;

@Configuration //1 main configuration that imports other configs, if put in array can import multiple
@Import({
	DatabaseLayerConfig.class
})
public class SpringConfig {
	
	public static void main(String[] args) {
		//start a Spring App - by creating the IoC Container
		//IoC is called a BeanFactory in Spring - Now more recently called ApplicationContext in Spring
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class); //Takes our public class config
		ExpenseController controller = context.getBean(ExpenseController.class);
		controller.callDao();
		//Singleton beans - default (bean scope)
		System.out.println("---------------Singleton scope------------");
		System.out.println(context.getBean(ExpenseController.class)); // always the same object
		System.out.println(context.getBean(ExpenseController.class));
		System.out.println(context.getBean(ExpenseController.class));
		System.out.println("-------------Prototype scope--------------");
		System.out.println(context.getBean(Expense.class)); // brand new instance with Prototype scope
		System.out.println(context.getBean(Expense.class));
		System.out.println(context.getBean(Expense.class));

	}
	
	//Bean Definitions - tells Spring to manage these beans
	@Bean
	public ExpenseController expenseController() {
		// call a setter or use a constructor (constructor injection or setter injection)
		ExpenseController controller = new ExpenseController();
		//controller.setDao(expenseDAO());  // Dependency Injection or called Bean Wiring
		return controller;
	}
	
	
}
