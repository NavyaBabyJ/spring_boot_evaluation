package com.nissan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nissan.model.Customer;



public interface IAdminService {
	
	//list
	public List<Customer> getCustomer();
	
	//insert
	public Customer saveCustomer(Customer customer);
	
	//delete
	public void deleteCustomer(int accountNumber);
	
	//search by account number
	public Customer getCustomer(int accountNumber);

	//update
	Customer updateCustomer(Customer customer, Customer customerNew);
	
	
	

}