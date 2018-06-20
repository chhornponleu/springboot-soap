package com.ponleu.soap.webservice;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapServerConfig {

	// MessageDispatcherServlet
	// url -> /ws/*

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(context);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/ws/*");
	}

	@Bean(name = "courses")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema courseSchema) {
		DefaultWsdl11Definition def = new DefaultWsdl11Definition();
		def.setPortTypeName("CoursePort");
		def.setTargetNamespace("http://ponleu.com/courses");
		def.setLocationUri("/ws");
		def.setSchema(courseSchema);
		return def;
	}

	// /ws/courses.wsdl
	@Bean
	public XsdSchema courseSchema() {
		return new SimpleXsdSchema(new ClassPathResource("schemas/course-details.xsd"));
	}

}
