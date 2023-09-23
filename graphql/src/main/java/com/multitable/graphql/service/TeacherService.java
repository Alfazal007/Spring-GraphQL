package com.multitable.graphql.service;

import com.multitable.graphql.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher addNewTeacher(Teacher teacher);

    Teacher updateTeacher(Teacher teacher, Long id);

    Teacher deleteTeacher(Long id);

    Teacher findSingleTeacher(Long id);

    List<Teacher> findAllTeacher();
}
