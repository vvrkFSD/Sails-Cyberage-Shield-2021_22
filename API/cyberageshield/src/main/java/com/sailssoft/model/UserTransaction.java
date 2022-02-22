package com.sailssoft.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="user_transaction")
public class UserTransaction {	
	
	@Id
	@GeneratedValue
	@Column(name="user_tid")
	private Long usertId;
	
	private boolean topic_status;
	private boolean set_status;
	private boolean full_status;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id",nullable = false)
	private User user;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="topic_id",referencedColumnName = "topicId")
	private Topic topic;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="set_id",referencedColumnName = "set_id")
	private QuestionSet questionSet;
	
	
	
	
}
