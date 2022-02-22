package com.sailssoft.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Topic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long topicId;
	
	@Column(name="topic_name")
	@Lob
	private String topicName;
	
	@Column(name="topic_content")
	@Lob
	private String topicContent;
	
	
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="topic_id",referencedColumnName = "topicId")
    private Set<QuestionSet> questionSets;
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="topic_id",referencedColumnName = "topicId")
	private Set<QuestionBank> questionBank;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn( name="topic_id",
                 referencedColumnName = "topicId"
                )
	private Set<UserTransaction> userTransactions;
	
	
	
	

}
