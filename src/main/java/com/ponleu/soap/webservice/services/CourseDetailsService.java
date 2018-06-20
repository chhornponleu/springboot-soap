package com.ponleu.soap.webservice.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ponleu.soap.webservice.bean.Course;

@Component
public class CourseDetailsService {
	private static List<Course> courseList = new ArrayList<>();

	static {
		courseList.add(new Course(1, "Spring Core", "10 steps"));
		courseList.add(new Course(2, "Spring Mvc", "10 steps"));
		courseList.add(new Course(4, "Spring Rest", "10 steps"));
		courseList.add(new Course(5, "Spring Soap", "10 steps"));
	}

	public Course getById(int id) {
		for (Course course : courseList) {
			if (course.getId() == id) {
				return course;
			}
		}
		return null;
	}

	public int deleteById(int id) {
		Iterator<Course> iterator = courseList.iterator();
		while (iterator.hasNext()) {
			Course course = iterator.next();
			if (course.getId() == id) {
				iterator.remove();
				return 1;
			}
		}
		return 0;
	}

	public List<Course> getAll() {
		return courseList;
	}

}
