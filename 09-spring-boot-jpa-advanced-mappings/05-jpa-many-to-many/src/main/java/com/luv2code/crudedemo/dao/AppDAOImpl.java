package com.luv2code.crudedemo.dao;

import com.luv2code.crudedemo.entity.Instructor;
import com.luv2code.crudedemo.entity.InstructorDetail;
import com.luv2code.crudedemo.entity.Student;
import com.luv2code.crudedemo.entity.course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDao{

//    define field for entity manager
    private EntityManager entityManager;

//    inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);

    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
//        retrieve the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        //        get courses
        List<course> courses = tempInstructor.getCourses();

//        break association of all courses for instruction
        for(course tempCourses : courses){
            tempCourses.setInstructor(null);
        }

//        delete the instructor
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
//        retrieve instructor detail
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

//        remove the associated object reference
//        break bi-directional link

        tempInstructorDetail.getInstructor().setInstructorDetail(null);
//        delete the instructor detail
        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<course> findCoursesByInstructorId(int theId) {

        // create query
        TypedQuery<course> query = entityManager.createQuery(
                "from course where instructor.id = :data", course.class);
        query.setParameter("data", theId);

        // execute query
        List<course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {

        // create query
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i "
                        + "JOIN FETCH i.courses "
                        + "JOIN FETCH i.instructorDetail " //be sure to add white space before double-quotes
                        + "where i.id = :data", Instructor.class);
        query.setParameter("data", theId);

        // execute query
        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    public course findCourseById(int theId) {
        return entityManager.find(course.class, theId);
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);

    }

    @Override
    @Transactional
    public void update(course tempCourse) {
        entityManager.merge(tempCourse);

    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {

        course tempCourse = entityManager.find(course.class, theId);
        entityManager.remove(tempCourse);
    }

    @Override
    @Transactional
    public void save(course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public course findCourseAndReviewsByCourseId(int theId) {
        // create query
        TypedQuery<course> query = entityManager.createQuery(
                "select c from course c "
                        + "JOIN FETCH c.review "
                        + "where c.id = :data", course.class);

        query.setParameter("data", theId);

        // execute query
        course course = query.getSingleResult();

        return course;
    }

    @Override
    public course findCourseAndStudentByCourseId(int theId) {
        // create query
        TypedQuery<course> query = entityManager.createQuery(
                "select c from course c "
                        + "JOIN FETCH c.students "
                        + "where c.id = :data", course.class);
        query.setParameter("data", theId);

        // execute query
        course course = query.getSingleResult();

        return course;

    }

    @Override
    public Student findStudentAndCoursesByStudentId(int theId) {
        // create query
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s "
                        + "JOIN FETCH s.courses "
                        + "where s.id = :data", Student.class);
        query.setParameter("data", theId);

        // execute query
        Student student = query.getSingleResult();

        return student;
    }

    @Override
    @Transactional
    public void update(Student tempStudent) {
        entityManager.merge(tempStudent);
    }

    @Override
    @Transactional
    public void deleteStudentById(int theId) {
//        retrieve the student
        Student tempStudent = entityManager.find(Student.class,theId);

//        delete the student
        entityManager.remove(tempStudent);
    }
}
