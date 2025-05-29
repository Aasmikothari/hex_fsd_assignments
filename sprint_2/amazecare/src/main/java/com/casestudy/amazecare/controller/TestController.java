package com.casestudy.amazecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.casestudy.amazecare.model.Test;
import com.casestudy.amazecare.service.TestService;

@RestController
public class TestController {

	@Autowired
	private TestService testService;


}
