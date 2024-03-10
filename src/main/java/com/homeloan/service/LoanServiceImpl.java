package com.homeloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.beans.LoanEntity;
import com.homeloan.dao.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService{

	@Autowired
	private LoanRepository loanRepository;
	
	
	@Override
	public LoanEntity saveEntity(LoanEntity loanEntity) {
		return loanRepository.save(loanEntity);
		
	}


	@Override
	public LoanEntity getbyUserId(int id) {
		return	loanRepository.findByUserId(id);
	}

	
}
