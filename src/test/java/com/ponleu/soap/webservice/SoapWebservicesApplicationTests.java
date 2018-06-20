package com.ponleu.soap.webservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ponleu.soap.client.services.GetCourseDetailsClientService;
import com.ponleu.soap.schemas.GetCourseDetailsResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SoapWebservicesApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private GetCourseDetailsClientService service;

	@Test
	public void getSourceDetail() {
		GetCourseDetailsResponse res = service.getById(1);
		try {
			System.out.println(new ObjectMapper().writeValueAsString(res));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getAllCourses() {
		try {
			System.out.println(new ObjectMapper().writeValueAsString(service.getAllCourses()));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
