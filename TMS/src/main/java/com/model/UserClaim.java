package com.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



public class UserClaim {
	private String expenseType;
	@Min(value = 0)
	@NotNull
	private double expenseAmt;
	@NotNull
//	@Pattern(regexp = "^[0-9]{5,}" )
	private String employeeId;

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public double getExpenseAmt() {
		return expenseAmt;
	}

	public void setExpenseAmt(double expenseAmt) {
		this.expenseAmt = expenseAmt;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
}
