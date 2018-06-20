package com.ponleu.soap.webservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.ponleu.soap.client.SoapClientGateway;
import com.ponleu.soap.client.services.GetCourseDetailsClientService;

@Configuration
public class SoapClientConfig {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.ponleu.soap.schemas");
		return marshaller;
	}

	@Bean
	public SoapClientGateway soapClientGateway(Jaxb2Marshaller marshaller) {
		SoapClientGateway client = new SoapClientGateway();
		client.setDefaultUri("http://localhost:8080/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public GetCourseDetailsClientService GetCourseDetailsClientService(SoapClientGateway soapClientGateway) {
		return new GetCourseDetailsClientService(soapClientGateway);
	}

}
