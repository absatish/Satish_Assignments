package rate.musicdirector.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestTemplateInstance {
	
	@Bean
	public RestOperations getRestTemplate() {
		final RestTemplate restTemplate=new RestTemplate();
		final HttpComponentsClientHttpRequestFactory requestFactory=new HttpComponentsClientHttpRequestFactory();
		final DefaultUriBuilderFactory uriBuilderFactory=new DefaultUriBuilderFactory();
		uriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
		restTemplate.setRequestFactory(requestFactory);
		restTemplate.setUriTemplateHandler(uriBuilderFactory);
		return restTemplate;
	}

}
