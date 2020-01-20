package com.yash.repositary;

import org.springframework.data.repository.CrudRepository;

import com.yash.dto.Question;

public interface QuestionRepositary extends CrudRepository<Question,Integer>{

	
}
