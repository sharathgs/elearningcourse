package com.elearning.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

	
	private int courseId;
	private String courseName;
	private int courseDuration;
	private String courseDescription;
	private Double courseFee;
	
}
