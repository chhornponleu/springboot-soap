package com.ponleu.soap.webservice.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ponleu.soap.schemas.CourseDetails;
import com.ponleu.soap.schemas.GetAllCourseDetailsRequest;
import com.ponleu.soap.schemas.GetAllCourseDetailsResponse;
import com.ponleu.soap.schemas.GetCourseDetailsRequest;
import com.ponleu.soap.schemas.GetCourseDetailsResponse;
import com.ponleu.soap.webservice.bean.Course;
import com.ponleu.soap.webservice.services.CourseDetailsService;

@Endpoint
public class CourseDetailsEndpoint {

	@Autowired
	CourseDetailsService service;

	@ResponsePayload
	@PayloadRoot(namespace = "http://ponleu.com/courses", localPart = "GetCourseDetailsRequest")
	public GetCourseDetailsResponse processCourseDetailRequest(@RequestPayload GetCourseDetailsRequest request) {
		Course course = service.getById(request.getId());
		return mapCourseDetails(course);
	}

	@ResponsePayload
	@PayloadRoot(namespace = "http://ponleu.com/courses", localPart = "GetAllCourseDetailsRequest")
	public GetAllCourseDetailsResponse processAllCourseDetailRequest(
			@RequestPayload GetAllCourseDetailsRequest request) {
		List<Course> courses = service.getAll();
		return mapAllCourseDetails(courses);

	}

	private GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		for (Course course : courses) {
			response.getCourseDetails().add(mapCourse(course));
		}
		return response;
	}

	private GetCourseDetailsResponse mapCourseDetails(Course course) {
		if (course == null)
			return null;
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		CourseDetails courseDetails = mapCourse(course);
		response.setCourseDetails(courseDetails);
		return response;
	}

	private CourseDetails mapCourse(Course course) {
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(course.getId());
		courseDetails.setName(course.getName());
		courseDetails.setDescription(course.getDescription());
		return courseDetails;
	}

}
