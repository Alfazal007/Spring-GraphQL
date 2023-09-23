package com.multitable.graphql.controller;


import com.multitable.graphql.entity.Courses;
import com.multitable.graphql.entity.Student;
import com.multitable.graphql.entity.Teacher;
import com.multitable.graphql.service.CourseService;
import com.multitable.graphql.service.StudentService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @MutationMapping("studentinput")
    public Student addNewStudent(@Argument StudentInput studentInput) {
        System.out.println("Here");
        Student student = Student.builder()
                .teacher(studentInput.getTeacher())
                .name(studentInput.getName())
                .build();
        return studentService.addNewStudent(student);
    }
    @MutationMapping("editstudent")
    public Student updateStudent(@Argument UpdateStudent student, @Argument Long id) {
        Student student1 = Student.builder()
                .name(student.getName())
                .teacher(student.getTeacher())
                .build();
        return studentService.updateStudent(student1, id);
    }

    @MutationMapping("deletestudent")
    public Student deleteAStudent(@Argument Long studentId) {
        return studentService.deleteStudent(studentId);
    }

    @QueryMapping("allStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    @QueryMapping("student")
    public Student getAllStudents(@Argument Long studentId) {
        return studentService.getSingleStudents(studentId);
    }
}
@Getter
@Setter
class UpdateStudent {
    String name;
    Teacher teacher;
}

@Getter
@Setter
class StudentInput {
    String name;
    Teacher teacher;
}