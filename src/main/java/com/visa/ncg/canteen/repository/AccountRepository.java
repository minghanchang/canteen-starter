package com.visa.ncg.canteen.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.visa.ncg.canteen.model.Account;

@Repository
public class AccountRepository {
	private List<Account> accountsRepo;
	private AtomicLong orderIdGenerator = new AtomicLong(1L);
	
	public AccountRepository() {
		accountsRepo = new ArrayList<>();
	}
	
	public AccountRepository(List<Account> accountsRepo) {
		this.accountsRepo = accountsRepo;
	}
	
	public void save(Account acct) {
		if(acct.getId() == null) {
			long orderId = orderIdGenerator.getAndIncrement();
			acct.setId(orderId);
		}
		accountsRepo.add(acct);
	}
	
	public Account findById(Long acctId) {
		for(Account a : accountsRepo) {
			if(a.getId().equals(acctId))
				return a;
		}
		return null;
	}
	
	public List<Account> findAll() {
		return accountsRepo;
	}
	
}
