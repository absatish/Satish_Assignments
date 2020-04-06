package com.list.MusicDirectors;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTfulMusicDirectorsControllerAPI {

	@RequestMapping("/")
	public Optional<String> home() throws Exception{
		throw new Exception("Exception Raised Successfully..!HeHe..!You are not found..!");
	}
}
