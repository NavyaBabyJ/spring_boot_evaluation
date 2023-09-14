package com.nissan.rest;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.model.Customer;
import com.nissan.service.IAdminService;
import com.nissan.util.JwtUtil;

@RestController
@RequestMapping("/api")

public class AdminController {
	
	
	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private APIResponse apiResponse;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	//list
	@GetMapping("/customers")
	public List<Customer> getCustomer(@RequestHeader(value="authorization",defaultValue="")String auth) throws AccessDeniedException{
		jwtUtil.verify(auth);
		return adminService.getCustomer();
	}
	
	//search by accountNumber
	@GetMapping("/customer/search/{accountNumber}")
	public Customer getCustomer(@PathVariable int accountNumber,@RequestHeader(value="authorization",defaultValue="")String auth) throws AccessDeniedException {
		jwtUtil.verify(auth);
		return adminService.getCustomer(accountNumber);
		
	}

	//add customer
	@PostMapping("/customers")
	public ResponseEntity<APIResponse> addCustomer(@RequestBody Customer customer){
		if(adminService.saveCustomer(customer)==null) {
			apiResponse.setData(("Name can have only alphabets"));
			apiResponse.setStatus(500);
			apiResponse.setError("Invalid name");
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}
		apiResponse.setData("Customer added sucessfully");
		apiResponse.setStatus(200);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		
	}
	
	//update customer
	@PutMapping("/customers/update/{accountNumber}")
	public void updateCustomer(@RequestBody Customer customer) {
		adminService.saveCustomer(customer);

	}
	
	//delete customer
	@PutMapping("/customers/delete/{accountNumber}")
	public void deleteCustomer(@PathVariable int accountNumber,@RequestHeader(value="authorization",defaultValue="")String auth)throws AccessDeniedException {
		jwtUtil.verify(auth);
		adminService.deleteCustomer(accountNumber);
		
	}
	
//	//search by name of customer
//	@GetMapping("/customers/search/{name}")
//	public List<Customer> getAllCustomerByName(@PathVariable String name,@RequestHeader(value="authorization",defaultValue="")String auth) throws AccessDeniedException{
//		jwtUtil.verify(auth);
//		return adminService.getCustomerByName(name);
//	}
	
}

