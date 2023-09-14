package com.nissan.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.model.Customer;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer,String>{
	
	//custom methods
	
	//deposit
	
	@Modifying
	@Transactional
	@Query("UPDATE Customer SET balance=balance+:amount WHERE accountNo=:accno")
	public int deposit(@Param("accno")int accountNumber, @Param("amount")int depositAmount);

	//withdraw
	
	@Modifying
	@Transactional
	@Query("UPDATE Customer c SET c.balance = c.balance - :amount WHERE c.accountNumber = :accountNumber AND (c.balance - :amount) >= c.minBalance")
	public int withdraw(@Param("accountNumber") int accountNumber, @Param("amount") int amount);
	
	//get balance
	@Query("SELECT balance FROM Customer WHERE accountNo=?1")
	public int getBalance(int accountNo);

	
	//debit
	@Modifying
	@Transactional
	@Query("UPDATE Customer SET balance=balance-?2 WHERE accountNumber=?1")
	public void debitFrom(int fromAcc,int amount);
	
	//credit
	@Modifying
	@Transactional
	@Query("UPDATE Customer SET balance=balance+?2 WHERE accountNumer=?1")
	public void creditTo(int toAcc,int amount);
	

}
