package com.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.dto.CourseDto;
import com.elearning.service.CourseService;


import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@Slf4j
public class CourseController {
	
	/**
	 * @author Sharath G S
	 * @param userId
	 */
	
	@Autowired
	CourseService courseService;
	
	@GetMapping("/elearning/users/{userId}/courses")
	public ResponseEntity<List<CourseDto>> getCourses(@PathVariable("userId") int userId)
	{
		log.info("get event for all Courses called");
		return new ResponseEntity<>(courseService.getCourses(userId), HttpStatus.OK);
	}
	
	
	@GetMapping("/elearning/courses/{courseId}")
	public ResponseEntity<CourseDto> getCourse(@PathVariable("courseId") int courseId)
	{
		log.info("get event for particular Course called");
		return new ResponseEntity<>(courseService.getCourse(courseId),HttpStatus.OK);
	}

}
