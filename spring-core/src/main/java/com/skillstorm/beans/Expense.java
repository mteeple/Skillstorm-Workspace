package com.skillstorm.beans;

public class Expense {
	private String reason;
	private double amount;
	public Expense() {
		super();
	}
	public Expense(String reason, double amount) {
		super();
		this.reason = reason;
		this.amount = amount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
