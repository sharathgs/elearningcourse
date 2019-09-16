package com.elearning.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dto.CourseDto;
import com.elearning.model.Course;
import com.elearning.repository.CourseRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {

	
	/**
	 * @author Sharath G S
	 * @apiNote userId integer
	 * @return display all courses
	 */
	
	@Autowired
	CourseRepository courseRepository;
	
	public List<CourseDto> getCourses(int userId) {
		List<Course> courseDetails = courseRepository.findAll();
		
		//List<CourseDto> bList = courseDetails.stream().map(Course::CourseDto).collect(Collectors.toList());
		
		/*List<CourseDto> courseDtoList = courseDetails.stream().map(courses -> {
			CourseDto courseDto = new CourseDto();
			BeanUtils.copyProperties(courses, courseDto);
		}).collect(Collectors.toList());*/
		log.info("get event for all courses services called");
		
		List<CourseDto> courseDtoList = courseDetails.stream().collect(Collectors.mapping
				(p->new CourseDto(p.getCourseId(), p.getCourseName(), p.getCourseDuration(), p.getCourseDescription(), (double) p.getCourseDuration()), Collectors.toList()));
		
		return courseDtoList;
	}

	@Override
	public CourseDto getCourse(int courseId) {
		
		
		log.info("get event for particular course service called");
		Optional<Course> course = courseRepository.findById(courseId);
		CourseDto courseDto = new CourseDto();
				
		if(course.isPresent())
		{
			BeanUtils.copyProperties(course.get(), courseDto);
		}
		return courseDto;
	}

}
