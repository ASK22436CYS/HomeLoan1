package com.homeloan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.homeloan.beans.LoanEntity;

public interface LoanRepository extends JpaRepository<LoanEntity, Integer>{

	
	List<LoanEntity> findByUserId(int id);
	
	
	@Query(value = "select * from homeloan.loan_entity where user_id= :userid and id= :loanid",nativeQuery = true)
	LoanEntity getLoanEntity(@Param("userid") int userid,@Param("loanid") int loanid);
	
	
}