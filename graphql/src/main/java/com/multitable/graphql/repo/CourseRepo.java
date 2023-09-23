package com.multitable.graphql.repo;

import com.multitable.graphql.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Courses, Long> {
}
