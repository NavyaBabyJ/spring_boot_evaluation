package com.nissan.service;

import org.springframework.stereotype.Service;


public interface ICustomerService {
	
	//method for depositing
	public int deposit(int accountNumber,int depositAmount);
	
	//withdraw
	public int withdraw(int accountNumber,int amount);
	
	//balance
	public int showBalance(int accountNumber);
	
	//transfer
	public void transferAmount(int fromAcc, int toAcc, int amount);
}
