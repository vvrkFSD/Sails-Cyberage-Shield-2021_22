package com.sailssoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sailssoft.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long>{

}
