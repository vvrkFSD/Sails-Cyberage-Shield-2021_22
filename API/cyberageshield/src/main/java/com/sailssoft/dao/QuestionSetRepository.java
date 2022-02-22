package com.sailssoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sailssoft.model.QuestionSet;


public interface QuestionSetRepository extends JpaRepository<QuestionSet, Long>{
	
}
