package com.multitable.graphql.controller;


import com.multitable.graphql.entity.Courses;
import com.multitable.graphql.service.CourseService;
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
public class CourseController {
//    add new course
    @Autowired
    CourseService courseService;

    @MutationMapping("addcourse")
    public Courses addNewCourse(@Argument CoursesInput course) {
        Courses courses = Courses.builder()
                .name(course.getName())
                .platform(course.getPlatform())
                .build();
        return courseService.addNewCourse(courses);
    }
//    update existing course
    @MutationMapping("editcourse")
    public Courses updateCourse(@Argument CoursesInput course, @Argument Long id) {
        Courses courses = Courses.builder()
                .name(course.getName())
                .platform(course.getPlatform())
                .build();
        return courseService.updateCourse(courses, id);
    }

//    delete a course
    @MutationMapping("deleteCourse")
    public Courses deleteCourse(@Argument Long id) {
        return courseService.delete(id);
    }
//    get all courses

    @QueryMapping("allCourses")
    public List<Courses> getAllCourses() {
        return courseService.getAllCourses();
    }
//    get single course by id
    @QueryMapping("courses")
    public Courses getAllCourses(@Argument Long courseId) {
        return courseService.getOneCourses(courseId);
    }
}

@Getter
@Setter
class CoursesInput {
    String name;
    String platform;
}