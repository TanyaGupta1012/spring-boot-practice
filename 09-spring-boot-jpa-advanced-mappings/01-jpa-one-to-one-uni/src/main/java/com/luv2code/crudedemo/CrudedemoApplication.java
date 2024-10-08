package com.luv2code.crudedemo;

import com.luv2code.crudedemo.dao.AppDao;
import com.luv2code.crudedemo.entity.Instructor;
import com.luv2code.crudedemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudedemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (AppDao appDao){

		return runner -> {
//			createInstructor(appDao);
//			findInstructor(appDao);
			deleteInstructor(appDao);
		};

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
