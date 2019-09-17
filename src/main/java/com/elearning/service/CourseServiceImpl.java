package com.elearning.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.elearning.dto.CourseDto;
import com.elearning.model.Course;
import com.elearning.repository.CourseRepository;
import com.elearning.util.CourseUtil;

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
	
	@Autowired
	CourseUtil courseUtil;
	
	@Value("${service.url}")
	private String enrolledUrl;
	
	public List<CourseDto> getCourses(Integer userId) {
		
		enrolledUrl = enrolledUrl+userId+"/enroll";
		
		List<CourseDto> getEnrolledCourses = courseUtil.getCourseByEnrolled(userId, enrolledUrl).stream().collect(Collectors.mapping((p->new CourseDto(p.getCourseId(), p.getCourseName(), p.getCourseDuration(), p.getCourseDescription(), (double) p.getCourseDuration())), Collectors.toList()));;
		
		
		//getEnrolledCourses.stream().collect(Collectors.mapping((p->new CourseDto(p.getCourseId(), p.getCourseName(), p.getCourseDuration(), p.getCourseDescription(), (double) p.getCourseDuration())), Collectors.toList()));
		
		log.info("get event for all courses services called");
		
		List<Course> courseDetails = courseRepository.findAll();
		
		/*List<CourseDto> unavailable = courseDetails.stream()
                .filter(e -> (getEnrolledCourses.stream()
                        .filter(d -> d.getCourseId().equals(e.getCourseId())))
                        .collect(Collectors.toList()));*/
		
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
