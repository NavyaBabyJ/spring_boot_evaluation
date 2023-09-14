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
import com.nissan.service.ICustomerService;
import com.nissan.util.JwtUtil;

@RestController //@Controller+@Configuration
@RequestMapping("/api")

public class CustomerController {
	
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private APIResponse apiResponse;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	//deposit
	@PutMapping("/customer/deposit/{accountNumber}/{depositAmount}")
	public void deposit(@PathVariable int accountNumber,@PathVariable int depositAmount,@RequestHeader(value="authorization",defaultValue="")String auth) throws AccessDeniedException {
		jwtUtil.verify(auth);
		customerService.deposit(accountNumber,depositAmount);
		
	}

	//withdraw
	@PutMapping("/customer/withdraw/{accountNumber}")
	public void withdraw(@PathVariable int accountNumber,@PathVariable int amount,@RequestHeader(value="authorization",defaultValue="")String auth) throws AccessDeniedException {
		jwtUtil.verify(auth);
		customerService.withdraw(accountNumber,amount);
	}
	
	//balance
	@GetMapping("/customer/balance/{accountNumber}")
	public void showBalance(@PathVariable int accountNumber,@RequestHeader(value="authorization",defaultValue="")String auth) throws AccessDeniedException {
		jwtUtil.verify(auth);
		customerService.showBalance(accountNumber);
	}
	
	//transfer
	@GetMapping("/customer/transfer/{fromAcc}/{toAcc}/{amount}")
	public void transfer(@PathVariable int fromAcc,@PathVariable int toAcc,@PathVariable int amount,
			@RequestHeader(value="authorization",defaultValue="")String auth)throws AccessDeniedException{
		jwtUtil.verify(auth);
		customerService.transferAmount(fromAcc, toAcc,amount);
	}
	
	

	
	}

