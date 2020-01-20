package com.yash.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dto.Question;
import com.yash.repositary.QuestionRepositary;

@Service
public class QuestionService 
{
	@Autowired
	private QuestionRepositary questionRepositary;
	
	public List<Question> getAllQuestion()
	{
		List<Question> qList=new ArrayList<Question>();
		questionRepositary.findAll().forEach(question->qList.add(question));
		return qList;
	}
	public void saveQuestion(String question,String optionA,String optionB,String optionC,String optionD,String rightOption)
	{
		Question q=new Question(question, optionA, optionB, optionC, optionD, rightOption);
		questionRepositary.save(q);
	}
	public void updateQuestion(int qno,String question,String optionA,String optionB,String optionC,String optionD,String rightOption)
	{
		Question q=new Question(qno, question, optionA, optionB, optionC, optionD, rightOption);
		questionRepositary.save(q);
	}
	public Question findQuestionById(int id)
	{
		try
		{
			Question q=questionRepositary.findById(id).get();
			return q;
		}
		catch(Exception e)
		{
			return null;
		}
		
	}
	public void deleteQuestion(int qId)
	{ 
		Question q=new Question(qId);
		questionRepositary.delete(q);
		
	}
}
