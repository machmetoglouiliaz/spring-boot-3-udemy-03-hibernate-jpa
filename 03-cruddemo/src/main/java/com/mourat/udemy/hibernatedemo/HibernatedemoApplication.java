package com.mourat.udemy.hibernatedemo;

import com.mourat.udemy.hibernatedemo.dao.StudentDAO;
import com.mourat.udemy.hibernatedemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernatedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatedemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO dao){
		return runner -> {
			readStudentByID(dao, 1);
		};
	}

	// a different version of method than tutorial
	public void createMultipleStudents(StudentDAO dao){

		// create 3 students and save them
		createStudent(dao, "Konstantinos", "Vardakis", "kvar@gmail.com");
		createStudent(dao, "Seyran", "Osman", "toPontiki@gmail.com");
		createStudent(dao, "Sali", "Kotza Xasan", "khsali@gmail.com");
	}

	private void createStudent(StudentDAO dao, String fName, String lName, String email){

		// create the student object
		Student student = new Student(fName, lName, email);

		// save the student object
		dao.save(student);

		//display the id of the created student
		System.out.println("Student created with ID: " + student.getId());
	}

	private void readStudentByID(StudentDAO dao, int id){
		System.out.println("The student data with id " + id + ":");
		System.out.println(dao.findById(id).toString());
	}
}
