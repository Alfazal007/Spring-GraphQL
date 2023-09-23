package com.multitable.graphql.service.serviceimpl;

import com.multitable.graphql.entity.Courses;
import com.multitable.graphql.entity.Student;
import com.multitable.graphql.entity.Teacher;
import com.multitable.graphql.repo.CourseRepo;
import com.multitable.graphql.repo.StudentRepo;
import com.multitable.graphql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    CourseRepo coursesRepository;
    @Override
    public Student addNewStudent(Student student) {
        studentRepo.save(student);
        return student;
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        Student existing = studentRepo.findById(id).orElseThrow(()-> new RuntimeException("No student with this id found"));
        if(student.getName() != null) {
            existing.setName(student.getName());
        }
        if(student.getTeacher() != null) {
            existing.setTeacher(student.getTeacher());
        }
        return studentRepo.save(existing);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getSingleStudents(Long id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public Student deleteStudent(Long studentId) {
        Student studentToBeDeleted = studentRepo.findById(studentId).get();
        studentRepo.deleteById(studentId);
        return studentToBeDeleted;
    }
}
