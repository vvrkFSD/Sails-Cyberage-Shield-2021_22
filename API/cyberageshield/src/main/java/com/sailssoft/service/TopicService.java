package com.sailssoft.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sailssoft.model.Topic;


@Service
public interface TopicService {
	public Topic addTopic(Topic topic);

	public ResponseEntity<Topic> fetchTopicById(Long topic_id);

	public Topic updateTopicById(Long topic_id, Topic topic);

	public void deleteTopicById(Long topic_id);

	public List<Topic> fetchTopicList();

}
