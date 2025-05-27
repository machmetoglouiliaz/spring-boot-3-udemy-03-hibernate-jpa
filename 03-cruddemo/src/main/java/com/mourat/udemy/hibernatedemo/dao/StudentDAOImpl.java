package com.mourat.udemy.hibernatedemo.dao;

import com.mourat.udemy.hibernatedemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define fields for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student){
        entityManager.persist(student);
    }

    // implement find method with id
    @Override
    public Student findById(int id){
        return entityManager.find(Student.class, id);
    }

    // implement find method for all students
    @Override
    public List<Student> findAll(){
        // create the quary to get students
        TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY lastName", Student.class);

        // get the list of students with executing above query
        return  query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {

        // create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:lName", Student.class);

        // set the parameter
        query.setParameter("lName", lastName);

        //return results
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student){
        entityManager.merge(student);
    }
}
