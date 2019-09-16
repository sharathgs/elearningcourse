package com.elearning.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.elearning.dto.CourseDto;
import com.elearning.model.Course;
import com.elearning.repository.CourseRepository;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceTest {

	@InjectMocks
	CourseServiceImpl courseService;
	
	
	@Mock
	CourseRepository courseRepository;
	Course course ;
	Course course1 ;
	
	List<Course> getCourseAllDetails ;

	public void setup() {

		 course = new Course();
		course.setCourseDescription("Java By sharath");
		course.setCourseDuration(5);
		course.setCourseFee((double) 5000);
		course.setCourseId(1);
		course.setCourseName("Java");
		
		 course1 = new Course();
		course1.setCourseDescription("Spring By sharath");
		course1.setCourseDuration(5);
		course1.setCourseFee((double) 5000);
		course1.setCourseId(2);
		course1.setCourseName("Spring");

		 getCourseAllDetails = new ArrayList<>();

		 getCourseAllDetails.add(course);
		 getCourseAllDetails.add(course1);
		 
	}
	
	
	
	
	
	@Test
	public void getCourseDetailsTest()
	{		
		Mockito.when(courseRepository.findAll()).thenReturn(getCourseAllDetails);
		List<CourseDto> getCourseDetails = courseService.getCourses(Mockito.anyInt());
		Assert.assertEquals(getCourseDetails.size(),getCourseAllDetails.size());
	}
	
}
