package com.service;

import org.springframework.stereotype.Service;

import com.model.UserClaim;

public interface TaxService {
	public double calculateTax(UserClaim userClaim);
}
