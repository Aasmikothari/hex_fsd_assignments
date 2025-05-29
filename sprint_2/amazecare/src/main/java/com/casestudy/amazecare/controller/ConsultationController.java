package com.casestudy.amazecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.casestudy.amazecare.model.Consultation;
import com.casestudy.amazecare.service.ConsultationService;

@RestController
public class ConsultationController {

	@Autowired
	private ConsultationService consultationService;

}
