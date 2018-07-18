package com.visa.ncg.canteen.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.visa.ncg.canteen.exception.NoSuchAccountException;
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
		if(acct == null) {
			throw new NoSuchAccountException();
		}
		AccountResponse acctRes = new AccountResponse(acct.getId(), acct.getBalance(), acct.name());
		model.addAttribute("account", acctRes);
		return "account-view";
	}
	
	@GetMapping("/accounts")
	public String browse(Model model) {
		Collection<Account> accts = acctRepo.findAll();
		List<AccountResponse> acctsRes = new ArrayList<>();
		for(Account a : accts) {
			acctsRes.add(new AccountResponse(a.getId(), a.getBalance(), a.name()));
		}
		model.addAttribute("accounts", acctsRes);
		return "all-accounts";
	}
	
	@PostMapping("/create-account")
	public String createAccount(@ModelAttribute("accountName") String name) {
		Account acct = new Account();
		acct.changeNameTo(name);
		acctRepo.save(acct);
		return "redirect:/accounts";
	}
	
	@GetMapping("/create-account")
	public String createAccountForm() {
		return "create-account";
	}

}
