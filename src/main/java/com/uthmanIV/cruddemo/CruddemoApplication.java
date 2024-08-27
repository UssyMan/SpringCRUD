package com.uthmanIV.cruddemo;

import com.uthmanIV.cruddemo.entity.DAO.StudentDAO;
import com.uthmanIV.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
            //getStudentById(studentDAO);
			//System.out.println(findByLastName(studentDAO,"Sheme"));
			//deleteStudent(studentDAO,4L);
			//System.out.println(getAllStudents(studentDAO));
			//updateStudentDetails(studentDAO,2L,"Ali", "Abuhuraira","aliyu@gmail.com");
			//deleteAll(studentDAO);


		};
	}

	private void deleteStudent(StudentDAO studentDAO,long l) {
		Student student = studentDAO.findById(l);
		studentDAO.deleteById(l);
		System.out.printf("Deleted %s %s",student.getFirstName(),student.getLastName());
	}
	private void deleteAll(StudentDAO studentDAO){
		studentDAO.deleteAll();
		System.out.println("Deleted All Records.....");
	}
	private void reAttach(StudentDAO studentDAO){
		studentDAO.reattach(4L);
	}



	private void getStudentById(StudentDAO studentDAO) {
        Student usman = studentDAO.findById(1L); //change id to integer
        System.out.println(usman);
    }
	private List<Student> getAllStudents(StudentDAO studentDAO){
		return studentDAO.findAll();
	}

    private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("Usman","Yahaya","uthmaniv@gmail.com");
		Student student2 = new Student("Mahadi","Abuhuraira","mamt4real@gmail.com");
		Student student3 = new Student("Mustapha","Sanusi","musteey@gmail.com");
		Student student4 = new Student("Ibrahim","Sheme","sheme@gmail.com");
		studentDAO.save(student);
		studentDAO.save(student2);
		studentDAO.save(student3);
		studentDAO.save(student4);
//		System.out.printf("Student Name: %s %s%nEmail : %s%nId: %d%n",
//				student.getFirstName(),
//				student.getLastName(),
//				student.getEmail(),
//				student.getID());
	}
	private Student findByLastName(StudentDAO studentDAO,String lName){
		return studentDAO.findByLastName(lName);
	}
	private void updateStudentDetails(
			StudentDAO studentDAO,
			Long id,
			String fName,
			String lName,
			String email){
		Student student = studentDAO.findById(id);
		System.out.printf("Updated %s %s details to >>>>>> ",student.getFirstName(),student.getLastName());
		studentDAO.updateDetails(id,fName,lName,email);
		Student updatedStudent = studentDAO.findById(id);
		System.out.println(updatedStudent);


	}

}
