package com.nissan.service;

import org.springframework.stereotype.Service;

import com.nissan.repo.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	private ICustomerRepository repo;

	@Override
	public int deposit(int accountNumber, int depositAmount) {
		// TODO Auto-generated method stub
		return repo.deposit(accountNumber,depositAmount);
	}

//	@Override
//	public void withdraw(String accountNumber, int amount) {
//		// TODO Auto-generated method stub
//		


	@Override
	public int showBalance(int accountNumber) {
		// TODO Auto-generated method stub
		return  repo.getBalance(accountNumber);
		
	}

	@Override
	public int withdraw(int accountNumber, int amount) {
		// TODO Auto-generated method stub
		return repo.withdraw(accountNumber,amount);
	}

	@Override
	public void transferAmount(int fromAcc, int toAcc, int amount) {
		int balance=repo.getBalance(fromAcc);
		float minBal=repo.getBalance(fromAcc);
		if(balance-minBal>amount) {
			repo.debitFrom(fromAcc,amount);
			repo.creditTo(toAcc,amount);
		}
	}

	

}
