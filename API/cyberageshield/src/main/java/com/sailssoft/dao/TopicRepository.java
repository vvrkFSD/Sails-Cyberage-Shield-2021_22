package com.sailssoft.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sailssoft.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {



}
