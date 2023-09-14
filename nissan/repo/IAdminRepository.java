package com.nissan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.model.Customer;

@Repository
public interface IAdminRepository extends CrudRepository<Customer,Integer>{
	
	//search by name
	
	@Query("from Customer WHERE customerName like %?1%")
	public List<Customer> findByCustomerName(String name);
	
	//delete customer
	@Modifying
	@Query("UPDATE com.nissan.model.Customer SET is_active=0 where accountNumber=?1")
	public void deleteCustomer(int accountNumber);
	

	

}
