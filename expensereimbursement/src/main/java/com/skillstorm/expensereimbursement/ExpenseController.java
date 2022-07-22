package com.skillstorm.expensereimbursement;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.DAO.ExpenseDAO;
import com.skillstorm.beans.Expense;

@WebServlet(urlPatterns = "/request")
public class ExpenseController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		try {
			ExpenseDAO dao = new ExpenseDAO();
			resp.getWriter().print(new ObjectMapper().writeValueAsString(dao.findAll()));
		} catch (IOException | SQLException | ClassNotFoundException e) {
			System.out.println("issue occuring in doGet");
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		try {
			ExpenseDAO dao = new ExpenseDAO();
			dao.create(new ObjectMapper().readValue(req.getInputStream(), Expense.class));
		} catch (SQLException | IOException | ClassNotFoundException e) {
			System.out.println("issue occuring in doPost");
			e.printStackTrace();
		}	
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ExpenseDAO dao = new ExpenseDAO();
			Relations num = new ObjectMapper().readValue(req.getInputStream(), Relations.class);			
			dao.updateById(num.geteID(), num.getrID());
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("issue occuring in doPut");
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ExpenseDAO dao = new ExpenseDAO();
			Relations num = new ObjectMapper().readValue(req.getInputStream(), Relations.class);			
			dao.deleteById(num.geteID());
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("issue occuring in doDelete");
			e.printStackTrace();
		}
	}
}

class Relations{
	private int eID;
	private int rID;
	public int geteID() {
		return eID;
	}
	public void seteID(int eID) {
		this.eID = eID;
	}
	public int getrID() {
		return rID;
	}
	public void setrID(int rID) {
		this.rID = rID;
	}	
}