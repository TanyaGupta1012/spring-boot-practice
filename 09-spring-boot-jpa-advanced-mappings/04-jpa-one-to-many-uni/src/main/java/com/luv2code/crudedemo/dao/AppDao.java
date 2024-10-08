package com.luv2code.crudedemo.dao;

import com.luv2code.crudedemo.entity.Instructor;
import com.luv2code.crudedemo.entity.InstructorDetail;
import com.luv2code.crudedemo.entity.course;

import java.util.List;

public interface AppDao {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId );

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    course findCourseById(int theId);

    void update(Instructor tempInstructor);

    void update(course tempCourse);

    void deleteCourseById(int theId);

    void save(course theCourse);

    course findCourseAndReviewsByCourseId(int theId);


}
