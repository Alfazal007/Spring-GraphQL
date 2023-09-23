package com.multitable.graphql.controller;

import com.multitable.graphql.entity.Courses;
import com.multitable.graphql.entity.Teacher;
import com.multitable.graphql.service.CourseService;
import com.multitable.graphql.service.TeacherService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @MutationMapping("addteacher")
    public Teacher addNewTeacher(@Argument TeacherInputput teacher) {
        Teacher teacher1 = Teacher.builder()
                .name(teacher.getName())
                .course(teacher.getCourse())
                .build();
        return teacherService.addNewTeacher(teacher1);
    }

    @MutationMapping("editteacher")
    public Teacher updateTeacher(@Argument TeacherInputput teacher, @Argument Long id) {
        System.out.println(teacher.course);
        Teacher teacher1 = Teacher.builder()
                .name(teacher.getName())
                .course(teacher.getCourse())
                .build();
        return teacherService.updateTeacher(teacher1, id);
    }

    @MutationMapping("deleteteacher")
    public Teacher deleteTeacher(@Argument Long id) {
        return teacherService.deleteTeacher(id);
    }


    @QueryMapping("teacher")
    public Teacher findSingleTeacher(@Argument Long teacherId) {
        return teacherService.findSingleTeacher(teacherId);
    }


    @QueryMapping("allTeachers")
    public List<Teacher> findSingleTeacher() {
        return teacherService.findAllTeacher();
    }
}

@Getter
@Setter
class TeacherInputput {
    String name;
    Courses course;
}