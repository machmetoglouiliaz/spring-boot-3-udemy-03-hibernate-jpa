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
			createStudent(dao);
		};
	}

	private void createStudent(StudentDAO dao){

		// create the student object
		Student student = new Student("Mourat", "Achoi", "mayrit91@gmail.com");

		// save the student object
		dao.save(student);

		//display the id of the created student
		System.out.println("Student created with ID: " + student.getId());
	}
}
