package com.multitable.graphql.service.serviceimpl;

import com.multitable.graphql.entity.Courses;
import com.multitable.graphql.entity.Teacher;
import com.multitable.graphql.repo.TeacherRepo;
import com.multitable.graphql.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepo teacherRepo;
    @Override
    public Teacher addNewTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher, Long id) {
        Teacher existing = teacherRepo.findById(id).orElseThrow(()->new RuntimeException("No teacher with this id exists"));
        if(teacher.getName() != null) {
            existing.setName(teacher.getName());
        }
        if(teacher.getCourse() != null) {
            existing.setCourse(teacher.getCourse());
        }
        return teacherRepo.save(existing);
    }

    @Override
    public Teacher deleteTeacher(Long id) {
        Teacher existing = teacherRepo.findById(id).orElseThrow(()->new RuntimeException("No teacher with this id exists"));
        teacherRepo.deleteById(id);
        return existing;
    }

    @Override
    public Teacher findSingleTeacher(Long id) {
        return teacherRepo.findById(id).get();
    }

    @Override
    public List<Teacher> findAllTeacher() {
        return teacherRepo.findAll();
    }
}
