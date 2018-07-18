package com.visa.ncg.canteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.visa.ncg.canteen.model.Account;
import com.visa.ncg.canteen.repository.AccountRepository;

@Component
public class AccountDataLoader implements ApplicationRunner {
	  private AccountRepository accountRepository;
	
	  public AccountDataLoader(AccountRepository accountRepository) {
	       this.accountRepository = accountRepository;
	  }
	
	  @Override
	  public void run(ApplicationArguments args) throws Exception {
	       Account account = new Account();
	       account.add(10);
	       account.changeNameTo("Darla");
	       accountRepository.save(account);
	       account = new Account();
	       account.add(10);
	       account.changeNameTo("MingHan");
	       accountRepository.save(account);
	  }
}