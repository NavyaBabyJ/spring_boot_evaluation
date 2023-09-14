package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.Validation;
import com.nissan.model.Customer;
import com.nissan.repo.IAdminRepository;

@Service
public class AdminServiceImpl implements IAdminService{

	@Autowired
	private IAdminRepository adminRepo;
	
	@Autowired
	private Validation validation;
	
	@Override
	public List<Customer> getCustomer() {
		return (List<Customer>) adminRepo.findAll() ;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		if(validation.isNameValid(customer.getCustomerName())){
		return adminRepo.save(customer);
		}
		return customer;
	}

	@Override
	public Customer getCustomer(int accountNumber) {
		return adminRepo.findById(accountNumber)
				.orElseThrow(()-> new
				RuntimeException("Customer not found "+accountNumber));
	}

	 
	@Override
	public void deleteCustomer(int accountNumber) {
		adminRepo.deleteCustomer(accountNumber);
		
	}

	@Override
	public Customer updateCustomer(Customer customer, Customer customerNew) {
	customer.setMobileNumber(customerNew.getMobileNumber());
	customer.setEmail(customerNew.getEmail());
	if(validation.isNameValid(customer.getCustomerName())) {
	return adminRepo.save(customer);
	}
	return adminRepo.save(customer);
	}

	

}
