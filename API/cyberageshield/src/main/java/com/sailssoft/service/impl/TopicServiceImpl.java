package com.sailssoft.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sailssoft.dao.TopicRepository;
import com.sailssoft.model.Topic;
import com.sailssoft.service.TopicService;
@Service
public class TopicServiceImpl implements TopicService{

	
	@Autowired
	TopicRepository topicRepository;
	@Override
	public Topic addTopic(Topic topic) {
		// TODO Auto-generated method stub
		return topicRepository.save(topic);
	}

	@Override
	public ResponseEntity<Topic> fetchTopicById(Long topic_id) {
		Optional<Topic> topic= topicRepository.findById(topic_id);
		if(topic== null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return new ResponseEntity<>(topic.get(),HttpStatus.OK);
		
	}

	@Override
	public Topic updateTopicById(Long topic_id, Topic topic) {
		// TODO Auto-generated method stub
		Topic topic_from_db= topicRepository.findById(topic_id).get();
		
		//checking for topic name (null checks and blank checks)
		if(Objects.nonNull(topic.getTopicName())&&!"".equalsIgnoreCase(topic.getTopicName())) {
			topic_from_db.setTopicName(topic.getTopicName());
		}

		if(Objects.nonNull(topic.getTopicContent())&&!"".equalsIgnoreCase(topic.getTopicContent())) {
				topic_from_db.setTopicContent(topic.getTopicContent());
			}
		
		
		return topicRepository.save(topic_from_db);
	}

	@Override
	public void deleteTopicById(Long topic_id) {
		// TODO Auto-generated method stub
		topicRepository.deleteById(topic_id);
		
	}

	@Override
	public List<Topic> fetchTopicList() {
		// TODO Auto-generated method stub
		return topicRepository.findAll();
	}

}
