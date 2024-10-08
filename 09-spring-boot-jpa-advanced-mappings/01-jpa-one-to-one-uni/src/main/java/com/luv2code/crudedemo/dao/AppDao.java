package com.luv2code.crudedemo.dao;

import com.luv2code.crudedemo.entity.Instructor;

public interface AppDao {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId );

    void deleteInstructorById(int theId);
}
