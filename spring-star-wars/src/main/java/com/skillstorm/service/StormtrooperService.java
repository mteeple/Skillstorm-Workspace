package com.skillstorm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.skillstorm.data.StormtrooperRepository;

@Service //replaced by Service, so we know its looking at the logic@Component
public class StormtrooperService {
	public StormtrooperService() {
		System.out.println("new StormtrooperService()");
	}
	
	@Autowired
	private StormtrooperRepository repository;
}
