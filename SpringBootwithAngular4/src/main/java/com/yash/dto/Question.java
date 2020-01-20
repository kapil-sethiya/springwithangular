package com.yash.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int qno;
	private String question;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String rightOption;
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Question(int qno) {
		super();
		this.qno = qno;
	}

	
	public Question(String question) {
		super();
		this.question = question;
	}


	public Question(String question, String optionA, String optionB, String optionC, String optionD,
			String rightOption) {
		super();
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.rightOption = rightOption;
	}

	public Question(int qno, String question, String optionA, String optionB, String optionC, String optionD,
			String rightOption) {
		super();
		this.qno = qno;
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.rightOption = rightOption;
	}
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getRightOption() {
		return rightOption;
	}
	public void setRightOption(String rightOption) {
		this.rightOption = rightOption;
	}
	@Override
	public String toString() {
		return "Question [qno=" + qno + ", question=" + question + ", optionA=" + optionA + ", optionB=" + optionB
				+ ", optionC=" + optionC + ", optionD=" + optionD + ", rightOption=" + rightOption + "]";
	}
	

}
