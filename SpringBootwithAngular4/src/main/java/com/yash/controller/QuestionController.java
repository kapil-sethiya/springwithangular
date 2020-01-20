package com.yash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.dto.Question;
import com.yash.service.QuestionService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

@RestController
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	private PrintWriter out=null;
	
	//@CrossOrigin(origins = "*")
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/Questions",method = RequestMethod.GET)
	public List<Question> getListAllQuestions()
	{
		return questionService.getAllQuestion();
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/AddQuestion",method = RequestMethod.POST)
	public int addQuestion(@RequestBody Question question)
	{
		int i=0;
		try
		{
			questionService.saveQuestion(question.getQuestion(),question.getOptionA(),question.getOptionB(),question.getOptionC(),question.getOptionD(),question.getRightOption());
			i=1;
		}
		catch(Exception e)
		{
			i=0;
			e.printStackTrace();
		}
		return i;
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/GetQuestion/{qid}",method = RequestMethod.GET)
	public Question getQuestion(@PathVariable("qid") int qid,HttpServletResponse response) throws IOException
	{
		Question q=questionService.findQuestionById(qid);
		if(q==null)
		{
			out=response.getWriter();
			response.getWriter().println("Question not available");
			return q;
		}
		return q;
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/UpdateQuestion",method =RequestMethod.POST)
	public int updateQuestion(@RequestBody Question question)
	{
		int i=0;
		try
		{
			questionService.updateQuestion(question.getQno(),question.getQuestion(),question.getOptionA(),question.getOptionB(),question.getOptionC(),question.getOptionD(),question.getRightOption());
			i=1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			i=0;
		}
		return i;
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/DeleteQuestion",method = RequestMethod.GET)
	public Object deleteQuestion(@RequestParam("id") int id,HttpServletResponse response)
	{
		int i=0;
		try
		{
			Question q=questionService.findQuestionById(id);
			System.err.println("---------------q "+q);
			if(q!=null)
			{
				questionService.deleteQuestion(id);
				i=1;
			}
			else {
				//response.getWriter().println("Question is deleted");
				return "Question is deleted";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
}
