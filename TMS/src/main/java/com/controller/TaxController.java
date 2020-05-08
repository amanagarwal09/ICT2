package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.UserClaim;
import com.service.TaxService;

@Controller
public class TaxController {

	@Autowired
	private TaxService taxService;

	@RequestMapping(value = "/getTaxClaimFormPage", method = RequestMethod.GET)
	public String claimPage(@ModelAttribute("userclaim") UserClaim obj) {
		return "taxclaim";
	}

	@RequestMapping(value = "/calculateTax", method = RequestMethod.GET)
	public String calculateTax(  @ModelAttribute("userclaim")  @Validated UserClaim userClaim,  BindingResult result,ModelMap model) {
		if(result.hasErrors()) { return "taxclaim"; }
		double totalCost = taxService.calculateTax(userClaim);
		model.put("type",userClaim.getExpenseType());
		model.put("amt",userClaim.getExpenseAmt());
		model.put("cost", totalCost);
		return "result";
	}

	@ModelAttribute("expenseList")
	public List<String> populateExpense() {
		List<String> mp = new ArrayList<String>();
		mp.add("MedicalExpense");
		mp.add("TravelExpense");
		mp.add("FoodExpense");
		return mp;
	}
}
