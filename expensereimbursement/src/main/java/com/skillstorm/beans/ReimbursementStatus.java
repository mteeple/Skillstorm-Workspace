package com.skillstorm.beans;

public class ReimbursementStatus {

	private String reimburStatus; 
	private int statusId; 
	
	public ReimbursementStatus() {
		super();
	}
	
	public ReimbursementStatus(int statusId) {
		super();
		if (statusId == 2) {
			this.reimburStatus = "Approved";
		} else if (statusId == 3) {
			this.reimburStatus = "Denied";
		} else {
			this.reimburStatus = "Pending";
		}
		this.statusId = statusId;
	}
	public String getReimburStatus() {
		return reimburStatus;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
		if (statusId == 2) {
			this.reimburStatus = "Approved";
		} else if (statusId == 3) {
			this.reimburStatus = "Denied";
		} else {
			this.reimburStatus = "Pending";
		}
	}
	
	public void setReimburStatus(String reimburStatus) {
		this.reimburStatus = reimburStatus;
	}
	
	@Override
	public String toString() {
		return "ReimbursementStatus [reimburStatus=" + reimburStatus + ", statusId=" + statusId + "]";
	}

}