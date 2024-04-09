package com.homeloan.service;

import java.util.List;

import com.homeloan.beans.LoanEntity;

public interface LoanService {

	public LoanEntity saveEntity(LoanEntity loanEntity);
	
	public List<LoanEntity> getbyUserId(int id);
	
	public LoanEntity getLoanentity(int userid,int loanid);
}
