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
	
	/*
	 * # AIM    : Assign a test to a patient
	 * # PATH   : /api/test/{patientId}
	 * # METHOD : POST
	 * # PARAM  : Path Variable (patientId), Request Body (Test)
	 * # RETURN : Test
	 */
	@PostMapping("/api/test/{patientId}")
	public Test addTestForPatient(@PathVariable int patientId, @RequestBody Test test) {
		return testService.addTestForPatient(patientId, test);
	}

	/*
	 * # AIM    : Get all tests assigned to a patient
	 * # PATH   : /api/test/patient/{patientId}
	 * # METHOD : GET
	 * # RETURN : List<Test>
	 */
	@GetMapping("/api/test/patient/{patientId}")
	public List<Test> getTestsByPatient(@PathVariable int patientId) {
		return testService.getTestsByPatientId(patientId);
	}

	/*
	 * # AIM    : Update a test (status, report path)
	 * # PATH   : /api/test/{testId}
	 * # METHOD : PUT
	 * # PARAM  : Path Variable (testId), Request Body (Test)
	 * # RETURN : Updated Test
	 */
	@PutMapping("/api/test/{testId}")
	public Test updateTest(@PathVariable int testId, @RequestBody Test updated) {
		return testService.updateTest(testId, updated);
	}

	/*
	 * # AIM    : Delete a test by ID
	 * # PATH   : /api/test/{testId}
	 * # METHOD : DELETE
	 * # RETURN : String
	 */
	@DeleteMapping("/api/test/{testId}")
	public String deleteTest(@PathVariable int testId) {
		testService.deleteTest(testId);
		return "Test deleted successfully";
	}


}
