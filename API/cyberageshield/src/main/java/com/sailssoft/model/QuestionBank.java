package com.sailssoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="question_bank")
public class QuestionBank {
	
	@Id
	@GeneratedValue
	@Column(name="question_id")
	private Long questionId;
	
	@Column(name="question_name")
	@Lob
	private String questionName;
	
	@Lob
	private String option1;
	@Lob
	private String option2;
	@Lob
	private String option3;
	@Lob
	private String option4;
	@Lob
	private String answer;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
			name="topic_id",
			referencedColumnName = "topicId")
	private Topic topic;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
			name="set_id",
			referencedColumnName = "set_id")
	private QuestionSet questionSet;
	
	
	
	
	
	
	
	
}
