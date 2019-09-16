package com.elearning.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CourseUtil {
	
	@Value("${service.url}")
	private String enrolledUrl;
	
	public List<?> getCourseByEnrolled(int userId)
	{
		List<?> retrunList = new ArrayList<>();
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response  = restTemplate.getForEntity(enrolledUrl, Object.class,userId);
		return retrunList;
	}

}
