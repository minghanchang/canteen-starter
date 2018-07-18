package com.visa.ncg.canteen.model;

import com.visa.ncg.canteen.InvalidAmountException;

public class AccountResponse {
	
	private Long id;
	private int balance;
	private String name;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AccountResponse(Long id, int balance, String name) {
		super();
		this.id = id;
		this.balance = balance;
		this.name = name;
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
