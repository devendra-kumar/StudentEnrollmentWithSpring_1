package com.github.elizabetht.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.github.elizabetht.model.Student;

@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Query("select s from Student s where s.userName = :userName")
	Student findByUserName(@Param("userName") String userName);
	
	@Query("Select s from Student s where s.Active =1 ")
	List<Student> getAllActiveStudent();
	
	@Query("Select s from Student s where s.id=:id and s.Active=1")
	Student getStudentByID(@Param("id")long id);
}
