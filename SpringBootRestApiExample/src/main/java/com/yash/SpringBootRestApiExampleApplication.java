package com.yash;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yash.student.Student;
import com.yash.student.StudentRepository;

@SpringBootApplication
public class SpringBootRestApiExampleApplication implements CommandLineRunner{

	@Autowired
	private StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//studentRepository.insertRecords(10001L,"Ranga","E1234567");
		//studentRepository.insertRecords(10002L,"Ravi","A1234568");
		studentRepository.save(new Student(10001L,"Ranga","E1234567"));
		studentRepository.save(new Student(10002L,"Ravi","A12345678"));
		List<Object[]> ob=studentRepository.findRecordPassportNumber("E1234567");
		for(Object o[]:ob)
		{
			System.out.println(o[0]+" : "+o[1]+" : "+o[2]);
		}
	}

}
