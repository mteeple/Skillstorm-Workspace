package com.skillstorm.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.skillstorm.beans.Expense;

import com.skillstorm.beans.ReimbursementStatus;

public class ExpenseDAO {
	private Connection conn;
	public ExpenseDAO() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensedb", "root", "root");
	}
	
	// adds new entries
	public void create(Expense expense) throws SQLException{
		ReimbursementStatus status = new ReimbursementStatus();
		String sql = "insert into expenses(employee_name, reason, notes, reimbursement_id) values (?, ?, ?, 1)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, expense.getEmployeeName());
		stmt.setString(2, expense.getExpenseReason());
		stmt.setString(3, expense.getExpenseNotes());
		stmt.executeUpdate(); 
	}
	
	// returns all the entries 
	public List<Expense> findAll() throws SQLException{
		List<Expense> list = new CopyOnWriteArrayList<>();		
		String sql = "select * from expenses";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		if(rs != null) {
			while (rs.next()) {
				Expense expense = new Expense(rs.getString("employee_name"), rs.getString("reason"), rs.getString("notes"), rs.getInt("reimbursement_id"));
				expense.setExpenseId(rs.getInt("expense_id"));
				ReimbursementStatus status = new ReimbursementStatus(rs.getInt("reimbursement_id"));
				expense.setStatus(status);
				list.add(expense);
			}			
			return list;
		}else
			return new CopyOnWriteArrayList<>();
	}
	
	// updates 
	public void updateById(int eID, int rID) throws SQLException{
		String sql = "update expenses set reimbursement_id = ? where expense_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, rID);
		stmt.setInt(2, eID);
		stmt.executeUpdate();
	}
	
	// deletes 
	public void deleteById(int id) throws SQLException {
		String sql = "delete from expenses where expense_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.executeUpdate();
	}
	
}