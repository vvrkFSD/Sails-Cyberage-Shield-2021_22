package com.sailssoft.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="question_set")
public class QuestionSet {
	
	
	@Id
	@GeneratedValue
	@Column(name="set_id")
	private Long setId;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
			name="topic_id",
			referencedColumnName = "topicId")
	private Topic topic;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn( name="set_id",
	             referencedColumnName = "set_id"
			    )
	private Set<QuestionBank> questionbank;
	

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="set_id",
                 referencedColumnName = "set_id")
	private Set<UserTransaction> userTransactions;
	
	
	
	
}
