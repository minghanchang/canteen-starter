package com.visa.ncg.canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.visa.ncg.canteen.model.Account;
import com.visa.ncg.canteen.model.AccountResponse;
import com.visa.ncg.canteen.repository.AccountRepository;

@Controller
public class AccountWebController {
	
	@Autowired
	AccountRepository acctRepo;
	
	@GetMapping("/account/{acctId}")
	public String accountView(@PathVariable("acctId") Long accountId, Model model) {
		Account acct = acctRepo.findById(accountId);
		AccountResponse acctRes = new AccountResponse(acct.getId(), acct.getBalance(), acct.name());
		model.addAttribute("account", acctRes);
		return "account-view";
	}
}
