package com.service;

import org.springframework.stereotype.Service;

import com.model.UserClaim;

@Service
public class TaxServiceImpl implements TaxService {
	@Override
	public double calculateTax(UserClaim userClaim) {
		double expenseAmt = userClaim.getExpenseAmt();
		String expenseType = userClaim.getExpenseType();
		double tax = 0;
		if (expenseType.equals("MedicalExpense")) {
			if (expenseAmt <= 1000) {
				tax = 15;
			} else if (expenseAmt <= 10000) {
				tax = 20;
			} else {
				tax = 25;
			}
		} else if (expenseType.equals("TravelExpense")) {
			if (expenseAmt <= 1000) {
				tax = 10;
			} else if (expenseAmt <= 10000) {
				tax = 15;
			} else {
				tax = 20;
			}
		} else {
			if (expenseAmt <= 1000) {
				tax = 5;
			} else if (expenseAmt <= 10000) {
				tax = 10;
			} else {
				tax = 15;
			}
		}
		double taxclaim = expenseAmt * tax / 100;
		return taxclaim;
	}

}
