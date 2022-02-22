package com.sailssoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sailssoft.model.UserTransaction;


public interface UserTransactionRepository extends JpaRepository<UserTransaction, Long>{

}
