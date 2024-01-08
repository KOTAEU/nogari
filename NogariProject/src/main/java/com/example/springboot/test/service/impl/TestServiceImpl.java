package com.example.springboot.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.TestEntity;
import com.example.springboot.test.repository.TestRepository;
import com.example.springboot.test.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestRepository testRepository;
	
	public void test() {
		TestEntity test = new TestEntity();
		test.setId("test00");
		test.setName("user00");
		test.setPassword("qwer00");
		testRepository.save(test); 
	}
	
}
