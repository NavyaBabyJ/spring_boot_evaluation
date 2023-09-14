package com.nissan.model;

import java.math.BigDecimal;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	
    @Id
    @Column(name="accountNumber")
    private int accountNumber; // Auto-generated 9-digit account number

    @Column(name="customerName",nullable=false,length=60)
	private String customerName;
    
    @Column(name="accountType",nullable=false,length=60)
    private String accountType;
    
    @Column(name="balance",nullable=false,length=60)
    private BigDecimal balance;
    
    @Column(name="minBalance",nullable=false,length=60)
    private BigDecimal minBalance;
    
    @Column(name="mobileNumber",nullable=false,length=60)
    private String mobileNumber;
    
    @Column(name="email",nullable=false,length=60)
    private String email;
    
    @Column(name="atmPin",nullable=false,length=60)
    private int atmPin; // Auto-generated 4-digit ATM PIN
    
    @Column(name="panCardNumber",nullable=false,length=60)
	private String panCardNumber;
    
//    @Column(name="is_active",nullable=false,length=60)
    private boolean is_active=true;

	public Customer() {
		super();
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
		Random random=new Random();
		accountNumber=(int) (100000000L+(long)(random.nextDouble()*900000000L));
	}
		

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(BigDecimal minBalance) {
		this.minBalance = minBalance;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAtmPin() {
		return atmPin;
	}
	

	public String getPanCardNumber() {
		return panCardNumber;
	}

	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}

	public void setAtmPin(int atmPin) {
		this.atmPin = atmPin;
		atmPin=(int)(Math.random()*9000)+1000;
	}
	
	
	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", customerName=" + customerName + ", accountType="
				+ accountType + ", balance=" + balance + ", minBalance=" + minBalance + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", atmPin=" + atmPin + ", panCardNumber=" + panCardNumber + ", is_active="
				+ is_active + "]";
	}
    
}


