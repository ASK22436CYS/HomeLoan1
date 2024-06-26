package com.homeloan.service;

import java.util.List;

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
	public List<LoanEntity> getbyUserId(int id) {
		return	loanRepository.findByUserId(id);
	}


	@Override
	public LoanEntity getLoanentity(int userid, int loanid) {
		
		return loanRepository.getLoanEntity(userid, loanid);
	}


	

	
}
