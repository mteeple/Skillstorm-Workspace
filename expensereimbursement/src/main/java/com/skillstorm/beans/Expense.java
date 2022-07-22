package com.skillstorm.beans;

public class Expense {

	private int expenseId; 
	private String employeeName; 
	private String expenseReason; 
	private String expenseNotes;  
	private ReimbursementStatus status; 
	
	public Expense() {
		super();
	}

	public Expense(String employeeName, String expenseReason, String expenseNotes) {
		super();
		this.employeeName = employeeName;
		this.expenseReason = expenseReason;
		this.expenseNotes = expenseNotes;
		this.status = new ReimbursementStatus(1);
		
	}
	public Expense(String employeeName, String expenseReason, String expenseNotes, int id) {
		super();
		this.employeeName = employeeName;
		this.expenseReason = expenseReason;
		this.expenseNotes = expenseNotes;
		this.status = new ReimbursementStatus(id);
	}

	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getExpenseReason() {
		return expenseReason;
	}
	public void setExpenseReason(String expenseReason) {
		this.expenseReason = expenseReason;
	}
	public String getExpenseNotes() {
		return expenseNotes;
	}
	public void setExpenseNotes(String expenseNotes) {
		this.expenseNotes = expenseNotes;
	}
	public ReimbursementStatus getStatus() {
		return status;
	}
	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Expense [expenseId=" + expenseId + ", employeeName=" + employeeName
				+ ", expenseReason=" + expenseReason + ", expenseNotes=" + expenseNotes + ", status=" + status + "]";
	}
	
	
	
}