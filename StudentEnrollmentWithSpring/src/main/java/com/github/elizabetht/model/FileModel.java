package com.github.elizabetht.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Question")
public class FileModel {

	@Id
	@GeneratedValue
	private long QuestionID;
	private String QuestionFileName;
	private String AnswerFileName1;
	private String AnswerFileName2;
	private String AnswerFileName3;
	private String AnswerFileName4;
	private String QuestionText;
	private String QuestionType;
	private int Active;

	public int getActive() {
		return Active;
	}

	public void setActive(int active) {
		Active = active;
	}

	public long getQuestionID() {
		return QuestionID;
	}

	public void setQuestionID(long questionID) {
		QuestionID = questionID;
	}

	public String getQuestionFileName() {
		return QuestionFileName;
	}

	public void setQuestionFileName(String questionFileName) {
		QuestionFileName = questionFileName;
	}

	public String getAnswerFileName1() {
		return AnswerFileName1;
	}

	public void setAnswerFileName1(String answerFileName1) {
		AnswerFileName1 = answerFileName1;
	}

	public String getAnswerFileName2() {
		return AnswerFileName2;
	}

	public void setAnswerFileName2(String answerFileName2) {
		AnswerFileName2 = answerFileName2;
	}

	public String getAnswerFileName3() {
		return AnswerFileName3;
	}

	public void setAnswerFileName3(String answerFileName3) {
		AnswerFileName3 = answerFileName3;
	}

	public String getAnswerFileName4() {
		return AnswerFileName4;
	}

	public void setAnswerFileName4(String answerFileName4) {
		AnswerFileName4 = answerFileName4;
	}

	public String getQuestionText() {
		return QuestionText;
	}

	public void setQuestionText(String questionText) {
		QuestionText = questionText;
	}

	public String getQuestionType() {
		return QuestionType;
	}

	public void setQuestionType(String questionType) {
		QuestionType = questionType;
	}

}
