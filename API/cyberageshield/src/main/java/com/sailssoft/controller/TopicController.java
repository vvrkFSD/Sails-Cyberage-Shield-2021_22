package com.sailssoft.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sailssoft.model.Topic;
import com.sailssoft.service.TopicService;
import com.sailssoft.service.UserService;

@RestController
@RequestMapping("/api/admin")
public class TopicController {
	
	@Autowired
	private TopicService topicService;  
	
	@PostMapping("/topics")
	public ResponseEntity<Topic> addTopic(@Validated  @RequestBody Topic topic) {
		try {
			topicService.addTopic(topic);
			return ResponseEntity.status(HttpStatus.CREATED).build();
			} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
	}
	
		
	@GetMapping("/topics")
	public ResponseEntity<List<Topic>> fetchTopicList(){
			List<Topic> list= topicService.fetchTopicList();
			if(list.size()<=0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(list)); 
			
		}
	
		
	@GetMapping("/topics/{id}")
	public ResponseEntity<Topic> fetchTopicById(@PathVariable("id") Long topic_id) {
		return topicService.fetchTopicById(topic_id);
			//return ResponseEntity.status(HttpStatus.OK).build(); 
		}
	
	
	@PutMapping("/topics/{id}")
	public ResponseEntity<Topic> updateTopicById( @Validated @PathVariable("id")Long topic_id,@RequestBody Topic topic)
	{ 
	try {
			topicService.updateTopicById(topic_id, topic);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
	catch (Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	}
	
	
	@DeleteMapping("/topics/{id}")
	public ResponseEntity<HttpStatus> deleteTopicById(@PathVariable("id") Long topic_id) {
		try {
			topicService.deleteTopicById(topic_id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} 
		catch (Exception e) {

			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
		}
	
	
	

}
