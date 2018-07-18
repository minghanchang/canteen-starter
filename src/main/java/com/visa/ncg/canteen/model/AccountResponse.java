package com.visa.ncg.canteen.model;

import com.visa.ncg.canteen.InvalidAmountException;

public class AccountResponse {
	
	private Long id;
	private int balance;

    public AccountResponse(Long id, int balance) {
		super();
		this.id = id;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

    public int add(int amount) {
        balance += amount;
        return balance;
    }

    public int withdraw(int amount) throws InvalidAmountException {
        balance -= amount;
        if(balance <0) throw new InvalidAmountException();
        return balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }




}
