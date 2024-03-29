package com.homeloan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homeloan.beans.Roles;
@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer>{

	Roles findByRole(String name);
}
