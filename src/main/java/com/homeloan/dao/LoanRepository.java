package com.homeloan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeloan.beans.LoanEntity;

public interface LoanRepository extends JpaRepository<LoanEntity, Integer>{

	LoanEntity findByUserId(int id);
}
