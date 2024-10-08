package com.luv2code.crudedemo.dao;

import com.luv2code.crudedemo.entity.Instructor;
import com.luv2code.crudedemo.entity.InstructorDetail;

public interface AppDao {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId );

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}
