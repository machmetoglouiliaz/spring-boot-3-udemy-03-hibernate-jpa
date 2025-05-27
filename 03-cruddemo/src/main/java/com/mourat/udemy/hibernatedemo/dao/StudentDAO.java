package com.mourat.udemy.hibernatedemo.dao;

import com.mourat.udemy.hibernatedemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();
}
