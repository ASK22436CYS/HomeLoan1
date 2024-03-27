package com.homeloan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeloan.beans.LoanEntity;

public interface LoanRepository extends JpaRepository<LoanEntity, Integer>{

	
	List<LoanEntity> findByUserId(int id);
}
