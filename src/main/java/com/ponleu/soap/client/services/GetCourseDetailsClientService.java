package com.ponleu.soap.client.services;

import com.ponleu.soap.client.SoapClientGateway;
import com.ponleu.soap.schemas.GetAllCourseDetailsRequest;
import com.ponleu.soap.schemas.GetAllCourseDetailsResponse;
import com.ponleu.soap.schemas.GetCourseDetailsRequest;
import com.ponleu.soap.schemas.GetCourseDetailsResponse;

public class GetCourseDetailsClientService {

	private final String ENDPOINT = "http://localhost:8080/ws";

	private SoapClientGateway soapClientGateway;

	public GetCourseDetailsClientService(SoapClientGateway soapClientGateway) {
		this.soapClientGateway = soapClientGateway;
	}

	public GetCourseDetailsResponse getById(int id) {
		GetCourseDetailsRequest req = new GetCourseDetailsRequest();
		req.setId(id);
		return (GetCourseDetailsResponse) soapClientGateway.makeCall(ENDPOINT, req);
	}

	public GetAllCourseDetailsResponse getAllCourses() {
		return (GetAllCourseDetailsResponse) soapClientGateway.makeCall(ENDPOINT, new GetAllCourseDetailsRequest());
	}

}
