package com.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elearning.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
