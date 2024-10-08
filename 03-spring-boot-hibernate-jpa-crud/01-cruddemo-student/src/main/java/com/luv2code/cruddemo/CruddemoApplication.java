package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
	// CommandlineRunner is from the Spring Boot Framework will be executed after the Spring Beans have been loaded
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO ){
		return runner ->{
//			 createStudent(studentDAO);

			 createMultipleStudents(studentDAO);

//			readStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count "+ numRowDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentID = 3;
		System.out.println("deleting student id: " + studentID);
		studentDAO.delete(studentID);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id: primary key
		int studentID = 1;
		System.out.println("Getting student with id " + studentID);
		Student myStudent = studentDAO.findById(studentID);

		//change first name to "Scooby"
		System.out.println("Updating student ...");
		myStudent.setFirstname("Scooby");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Update student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		//get a list of student
		List<Student> theStudents = studentDAO.findByLastName("Duck");

		//display the list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents  = studentDAO.findAll();

		//display the list of students
		for (Student tempStudents: theStudents){
			System.out.println(tempStudents);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating new student object ... ");
		Student tempStudent = new Student("Daffy" , "Duck", " Daffy@gmail.com");

		//save the student
		System.out.println("Saving the student ... ");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId= tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		//retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student mystudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the student: " + mystudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//create the multiple student object
		System.out.println("Creating 3 student object ... ");
		Student tempStudent1 = new Student("John" , "Doe" , "john@gamil.com");
		Student tempStudent2 = new Student("Merry" , "Public" , "merry@gamil.com");
		Student tempStudent3 = new Student("Bonita" , "Applebum" , "bonita@gamil.com");

		//save the student object
		System.out.println("Save the student ... ");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object ... ");
		Student tempStudent = new Student("Paul" , "Doe" , "paul@gamil.com");

		//save the student object
		System.out.println("Save the student ... ");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saced student. Genrated id " + tempStudent.getId());
	}

}
