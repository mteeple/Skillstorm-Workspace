package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.skillstorm.data.ExpenseDAO;

public class ExpenseController {
	@Autowired // looks inside the IOC contrainer for an ExpenseDAO bean then INJECT
	//@Primary and @Qualifier. Qualifier will override the Primary since that's only the default
	@Qualifier("hibernateDAO") //Specify which Bean to use (used if more than autowired choice)
	private ExpenseDAO dao; //NOT new DAO()
	
	public ExpenseController() {
		System.out.println("new ExpenseController()");
	}
	
	public void callDao() {
		dao.go();
	}

	public void setDao(ExpenseDAO dao) {
		this.dao = dao;
	}
	
	
}
