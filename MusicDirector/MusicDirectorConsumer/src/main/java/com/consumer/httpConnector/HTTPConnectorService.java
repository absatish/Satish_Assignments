package com.consumer.httpConnector;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class HTTPConnectorService{
	
	private static final String JsonContentType="application/json";
	
	public <N> HttpEntity<N> getHttpEntityJson(final N content){
		HttpHeaders httpHeader=getHttpHeadersAsJson(JsonContentType);
		return new HttpEntity<N>(content,httpHeader);
	}
	
	private HttpHeaders getHttpHeadersAsJson(final String contentType) {
		HttpHeaders header=new HttpHeaders();
		header.set("Content-Type", contentType);
		header.set("Accept", contentType);
		return header;
	}
}
