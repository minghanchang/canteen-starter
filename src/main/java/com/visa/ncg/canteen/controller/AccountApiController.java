package com.visa.ncg.canteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.visa.ncg.canteen.model.Account;
import com.visa.ncg.canteen.model.AccountResponse;
import com.visa.ncg.repository.AccountRepository;

@RestController
public class AccountApiController {
	
	@Autowired
	AccountRepository acctRepo;
	
//	@RequestMapping(value = "/accounts/{acctId}", method = RequestMethod.GET)
//	public Account accountInfo(@PathVariable("acctId") Long accountId) {
//		 Account acct = new Account();
//		 acct.setId(accountId);
//		 return acct;
//	}
	
//	@RequestMapping(value = "/api/accounts/{acctId}", method = RequestMethod.GET)
//	public ResponseEntity<AccountResponse> accountInfo(@PathVariable("acctId") Long accountId) {
//		 AccountResponse acct = new AccountResponse();
//		 acct.setId(accountId);
//		 acct.setBalance(10);
//		 return new ResponseEntity<>(acct, HttpStatus.OK);
//	}
	
	@RequestMapping(value = "/api/accounts/{acctId}", method = RequestMethod.GET)
	public ResponseEntity<AccountResponse> accountInfo(@PathVariable("acctId") Long accountId) {
		 Account acct = acctRepo.findById(accountId);
		 AccountResponse acctRe = new AccountResponse(acct.getId(), acct.getBalance());
		 return new ResponseEntity<>(acctRe, HttpStatus.OK);
	}
	
	
}
