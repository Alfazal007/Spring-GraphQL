package com.multitable.graphql.service;

import com.multitable.graphql.entity.Courses;

import java.util.List;

public interface CourseService {
    Courses addNewCourse(Courses course);

    Courses updateCourse(Courses course, Long id);

    Courses delete(Long id);

    List<Courses> getAllCourses();

    Courses getOneCourses(Long id);
}
