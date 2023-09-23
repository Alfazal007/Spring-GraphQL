package com.multitable.graphql.service.serviceimpl;

import com.multitable.graphql.entity.Courses;
import com.multitable.graphql.repo.CourseRepo;
import com.multitable.graphql.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepo courseRepo;
    @Override
    public Courses addNewCourse(Courses course) {
        return courseRepo.save(course);
    }

    @Override
    public Courses updateCourse(Courses course, Long id) {
        Courses existing = courseRepo.findById(id).orElseThrow(()->new RuntimeException("No course with this id exists"));
        if(course.getPlatform() != null) {
            existing.setPlatform(course.getPlatform());
        }
        if(course.getName() != null) {
            existing.setName(course.getName());
        }
        return courseRepo.save(existing);
    }

    @Override
    public Courses delete(Long id) {
        Courses existing = courseRepo.findById(id).orElseThrow(()->new RuntimeException("No course with this id exists"));
        courseRepo.deleteById(id);
        return existing;
    }

    @Override
    public List<Courses> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Courses getOneCourses(Long id) {
        return courseRepo.findById(id).get();
    }
}
