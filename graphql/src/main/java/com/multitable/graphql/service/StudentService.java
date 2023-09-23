package com.multitable.graphql.service;

import com.multitable.graphql.entity.Courses;
import com.multitable.graphql.entity.Student;

import java.util.List;

public interface StudentService {
    Student addNewStudent(Student student);

    Student updateStudent(Student student, Long id);

    List<Student> getAllStudents();

    Student getSingleStudents(Long id);

    Student deleteStudent(Long studentId);
}
