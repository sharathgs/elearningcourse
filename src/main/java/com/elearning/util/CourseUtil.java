package com.elearning.util;


import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.elearning.dto.CourseDto;

@Configuration
public class CourseUtil {
	
	@Value("${service.url}")
	private String enrolledUrl;
	
	public List<CourseDto> getCourseByEnrolled(int userId, String enrolledUrl)
	{
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<CourseDto>> response = restTemplate.exchange(
				enrolledUrl, HttpMethod.GET, null,   new ParameterizedTypeReference<List<CourseDto>>(){});
		List<CourseDto> enrolledCourses = response.getBody();
		return enrolledCourses;
	}

}
