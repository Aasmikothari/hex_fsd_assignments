package com.casestudy.amazecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.casestudy.amazecare.model.Prescription;
import com.casestudy.amazecare.service.PrescriptionService;

@RestController
public class PrescriptionController {

	@Autowired
	private PrescriptionService prescriptionService;

	
}
