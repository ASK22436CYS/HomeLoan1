package com.homeloan.service;

import com.homeloan.beans.LoanEntity;

public interface LoanService {

	public LoanEntity saveEntity(LoanEntity loanEntity);
	
	public LoanEntity getbyUserId(int id);
}
