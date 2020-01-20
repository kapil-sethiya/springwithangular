package com.yash.student;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	@Modifying
	@Query("select s.id,s.name,s.passportNumber from Student s where s.passportNumber=:passportNumber")
	List<Object[]> findRecordPassportNumber(@Param("passportNumber")String passportNumber);

}
