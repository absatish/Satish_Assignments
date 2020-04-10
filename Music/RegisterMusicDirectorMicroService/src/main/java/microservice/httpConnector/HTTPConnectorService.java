package microservice.httpConnector;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public class HTTPConnectorService {

	private static final String JsonContentType="application/json";
	
	public <N> HttpEntity<N> getHttpEntityJsonType(final N content){
		
		HttpHeaders headers=getHttpHeadersAsJson(JsonContentType);
		return new HttpEntity<>(content,headers);
		
	}

	private HttpHeaders getHttpHeadersAsJson(final String JsonContentType) {
		HttpHeaders header=new HttpHeaders();
		header.add("Content-Type", JsonContentType);
		header.add("Accept", JsonContentType);
		return header;
	}
}
