package com.ponleu.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SoapClientGateway extends WebServiceGatewaySupport {

	public Object makeCall(String url, Object requestPayload) {
		return this.getWebServiceTemplate().marshalSendAndReceive(url, requestPayload);
	}

}
