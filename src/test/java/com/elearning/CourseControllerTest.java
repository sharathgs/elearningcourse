package com.elearning;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.elearning.controller.CourseController;
import com.elearning.dto.CourseDto;
import com.elearning.model.Course;
import com.elearning.service.CourseService;


@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class CourseControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	CourseController courseController;
	
	@Mock
	CourseService courseService;
	
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();
    }
	
	public CourseDto getCourseDto()
	{
		CourseDto course = new CourseDto();
		course.setCourseDescription("Java By sharath");
		course.setCourseDuration(5);
		course.setCourseFee((double) 5000);
		course.setCourseId(1);
		course.setCourseName("Java");
		return course;
	}
	
	public CourseDto getCourseDto1()
	{
		CourseDto course = new CourseDto();
		course.setCourseDescription("Java By sharath");
		course.setCourseDuration(6);
		course.setCourseFee((double) 10000);
		course.setCourseId(2);
		course.setCourseName("Spring");
		return course;
	}
	
	
	@Test
	public void CourseDetailTest()
	{
		ResponseEntity<CourseDto> expResult = new ResponseEntity<>(getCourseDto(), HttpStatus.OK);
		when(courseService.getCourse(Mockito.anyInt())).thenReturn(getCourseDto());
		ResponseEntity<CourseDto> actResult = courseController.getCourse(Mockito.anyInt());
		assertEquals(expResult.getBody().getCourseDescription(), actResult.getBody().getCourseDescription());
	}
	
	@Test
	public void courseDetailsTest()
	{
		List<CourseDto> getDetails = new ArrayList<>();
		getDetails.add(getCourseDto());
		getDetails.add(getCourseDto1());
		
		
		ResponseEntity<List<CourseDto>> expResult = new ResponseEntity<>(getDetails, HttpStatus.OK);
		when(courseService.getCourses(Mockito.anyInt())).thenReturn(getDetails);
		ResponseEntity<List<CourseDto>> actResult = courseController.getCourses(Mockito.anyInt());
		assertEquals(expResult.getBody().size(), actResult.getBody().size());
	}

}
