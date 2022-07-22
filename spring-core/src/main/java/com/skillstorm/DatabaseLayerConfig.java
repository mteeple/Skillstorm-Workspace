package com.skillstorm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.skillstorm.beans.Expense;
import com.skillstorm.data.ExpenseDAO;
import com.skillstorm.data.ExpenseDAOHibernateImpl;
import com.skillstorm.data.ExpenseDAOImpl;

@Configuration
public class DatabaseLayerConfig {
	@Bean
	@Scope("prototype") //calling context.getBean produces a brand NEW object
	public Expense expense() {
		return new Expense();
	}
	
	@Bean //Bean definitions - tells Spring to manage these beans
	@Scope("singleton")
	@Primary //Default selection if there is more than one candidate for autowiring
	public ExpenseDAO expenseDAO() {
		return new ExpenseDAOImpl();
		//return new ExpenseDAOHibernateImpl();
		//return new ExpenseDAO(); No longer will work because its serving as an interface for the other two
	}
	
	@Bean
	public ExpenseDAO hibernateDAO() {
		return new ExpenseDAOHibernateImpl(); // ExpenseController needs an ExpenseDAO (2+ exception)
	}
}