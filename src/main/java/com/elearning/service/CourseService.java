package com.elearning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.elearning.dto.CourseDto;

@Service
public interface CourseService {

	public List<CourseDto> getCourses(Integer userId);
	
	public CourseDto getCourse(int courseId);
	
}
