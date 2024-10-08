package com.luv2code.crudedemo;

import com.luv2code.crudedemo.dao.AppDao;
import com.luv2code.crudedemo.entity.*;
import jakarta.persistence.Column;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudedemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (AppDao appDao){

		return runner -> {
//			createCourseAndStudents(appDao);
//			findCoursesAndStudent(appDao);
//			findStudentAndCourses(appDao);
//			addMoreCoursesForStudent(appDao);
//			deleteCourse(appDao);
			deleteStudent(appDao);
		};

	}

	private void deleteStudent(AppDao appDao) {
		int theId = 1;
		System.out.println("Deleting student id: "+ theId);
		appDao.deleteStudentById(theId);
		System.out.println("Done!");

	}

	private void addMoreCoursesForStudent(AppDao appDao) {
		int theId = 2;
		Student tempStudent = appDao.findStudentAndCoursesByStudentId(theId);

//		create more courses
		course tempCourse1 = new course("Rubik's Cube- How to Spend Cube");
		course tempCourse2 = new course("Atari 2700 - Game Development");

//		add courses to student
		tempStudent.addCourses(tempCourse1);
		tempStudent.addCourses(tempCourse2);

		System.out.println("Updating the Student: "+ tempStudent);
		System.out.println("associated courses: "+ tempStudent.getCourses());

		appDao.update(tempStudent);

		System.out.println("Done!");

	}

	private void findStudentAndCourses(AppDao appDao) {
		int theId = 2;
		Student tempStudent = appDao.findStudentAndCoursesByStudentId(theId);

		System.out.println("Loaded Student: "+ tempStudent);
		System.out.println("Courses: "+tempStudent.getCourses());

		System.out.println("Done!");

	}

	private void findCoursesAndStudent(AppDao appDao) {

		int theId = 10;
		course tempCourses = appDao.findCourseAndStudentByCourseId(theId);

		System.out.println("Loaded Course: "+ tempCourses);
		System.out.println("Students: "+tempCourses.getStudents());

		System.out.println("Done!");
	}

	private void createCourseAndStudents(AppDao appDao) {

//		create a course
		course tempCourse = new course("Pacman: How to Score One Million Points");

//		create the student
		Student tempStudent1 = new Student("John", "Doe" , "john@gmail.com");
		Student tempStudent2 = new Student("Mary", "Public" , "mary@gmail.com");

//		add student to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

//		save the course and the associated student
		System.out.println("Saving the Course: "+ tempCourse);
		System.out.println("associated students: "+ tempCourse.getStudents());

		appDao.save(tempCourse);

		System.out.println("Done!");
	}

	private void deleteCourseAndReviews(AppDao appDao) {

		int theId = 10;
		System.out.println("Deleting course id: "+ theId);
		appDao.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDao appDao) {

//		get the course and review
		int theId = 10;
		course tempCourse = appDao.findCourseAndReviewsByCourseId(theId);

		// print the course
		System.out.println(tempCourse);

//				print the associated reviews
		System.out.println(tempCourse.getReview());

		System.out.println("Done!");
	}

	private void createCourseAndReviews(AppDao appDao) {

//		create a course
		course tempCourse = new course("Pacman : How to Score One Million Points");

//		add some reviews
		tempCourse.addReview(new Review("Great course loved it!..."));
		tempCourse.addReview(new Review("Great job well done!..."));
		tempCourse.addReview(new Review("Didn't liked the course!..."));

//		save the course
		System.out.println("Saving the Course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReview());

		appDao.save(tempCourse);

		System.out.println("Done!");
	}

	private void deleteCourse(AppDao appDao) {

		int theId = 10;
		System.out.println("Deleting Course By Id: "+ theId);
		appDao.deleteCourseById(theId);
		System.out.println("Done!");

	}

	private void updateCourse(AppDao appDao) {
		int theId = 10;

		//		Finding Course
		System.out.println("Finding Course: "+ theId);
		course tempCourse = appDao.findCourseById(theId);

		//		updating Course
		System.out.println("Updating Course: "+theId);
		tempCourse.setTitle("Enjoy the Simple Things");

		appDao.update(tempCourse);

		System.out.println("Done!");


	}

	private void updateInstructor(AppDao appDao) {
		int theId = 1;

//		Finding Instructor
		System.out.println("Finding Instructor: "+ theId);
		Instructor tempInstructor = appDao.findInstructorById(theId);

//		updating instructor
		System.out.println("Updating Instructor: "+theId);
		tempInstructor.setLastName("TESTER");

		appDao.update(tempInstructor);

		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDao appDAO) {

		int theId = 1;

		// find the instructor
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDao appDao) {

		int theId = 1;
		// find instructor
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDao.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		// find courses for instructor
		System.out.println("Finding courses for instructor id: " + theId);
		List<course> courses = appDao.findCoursesByInstructorId(theId);

		// associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");

	}

	private void findInstructorWithCourses(AppDao appDao) {
		int theId = 1;
		System.out.println("Finding Instructor Id: "+ theId);
		Instructor tempInstructor = appDao.findInstructorById(theId);
		System.out.println("tempInstructor: "+ tempInstructor);
		System.out.println("the associated courses: "+ tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDao appDao) {

		//create the instructor
		Instructor tempInstructor = new Instructor("Susan", "Public", "susan.public@emai.com");

//		create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.youtube.com", "Video Game");

//		associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

//		Create Some Courses
		course tempCourse1 = new course("Air Guitar - The Ultimate Guitar");
		course tempCourse2 = new course ("The PinBall MasterClass");

//		add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

//		save instructor
//
//		NOTE: This will also save the course because of CascadeType.PERSIST
		System.out.println("Saving Instructor: "+tempInstructor);
		System.out.println("The Course: "+ tempInstructor.getCourses());
		appDao.save(tempInstructor);

		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDao appDao) {

		int theId = 3;
		System.out.println("Deleting instructor detail id: "+ theId);

		appDao.deleteInstructorDetailById(theId);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDao appDao) {
//		get the instructor detail object
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDao.findInstructorDetailById(theId);

//		print the instructor detail
		System.out.println("tempInstructorDetail: "+ tempInstructorDetail);

//		print the associated instructor
		System.out.println("the associated instructor: "+ tempInstructorDetail.getInstructor());

		System.out.println("Done!");
	}

	private void deleteInstructor(AppDao appDao) {
		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);

		appDao.deleteInstructorById(theId);

		System.out.println("Done!");
	}

	private void findInstructor(AppDao appDao) {

		int theId = 2;
		System.out.println("Finding instructor id: "+ theId);
		Instructor tempInstructor = appDao.findInstructorById(theId);
		System.out.println("tempInstructor: "+ tempInstructor);
		System.out.println("the associate instructorDetail only: " + tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDao appDao) {

//		//create the instructor
//		Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@emai.com");
//
////		create the instructor detail
//		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code");

		//create the instructor
		Instructor tempInstructor = new Instructor("Madhu", "Patel", "Madhu@emai.com");

//		create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.luv2code.com/youtube", "Guitar");

//		associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

//		save the instructor
//		NOTE: this will ALSO save the details object
//		because of CascadeType.ALL

		System.out.println("Saving instructor: "+tempInstructor);
		appDao.save(tempInstructor);

		System.out.println("Done!");

	}

}
