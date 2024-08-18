package com.uthmanIV.cruddemo;

import com.uthmanIV.cruddemo.entity.DAO.StudentDAO;
import com.uthmanIV.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("Usman","Yahaya","uthmaniv@gmail.com");

		studentDAO.save(student);
		System.out.printf("Student Name: %s %s%nEmail : %s%nId: %d",
				student.getFirstName(),
				student.getLastName(),
				student.getEmail(),
				student.getID());
	}

}
