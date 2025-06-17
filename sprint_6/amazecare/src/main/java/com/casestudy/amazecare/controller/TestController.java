package com.casestudy.amazecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.casestudy.amazecare.model.Test;
import com.casestudy.amazecare.service.TestService;

@RestController
@RequestMapping("/api/tests")
public class TestController {

    @Autowired
    private TestService testService;

    /*
     * AIM    : Get all tests by appointment ID
     * METHOD : GET
     * PATH   : /api/tests/appointment/{appointmentId}
     * RESPONSE : List of Test objects
     */
    @GetMapping("/appointment/{appointmentId}")
    public ResponseEntity<List<Test>> getTestsByAppointment(@PathVariable int appointmentId) {
        List<Test> tests = testService.getTestsByAppointmentId(appointmentId);
        return ResponseEntity.ok(tests);
    }

    /*
     * AIM    : Get all tests by status (Pending/Completed)
     * METHOD : GET
     * PATH   : /api/tests/status/{status}
     * RESPONSE : List of Test objects
     */
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Test>> getTestsByStatus(@PathVariable String status) {
        List<Test> tests = testService.getTestsByStatus(status);
        return ResponseEntity.ok(tests);
    }

    /*
     * AIM    : Update result and status of a test
     * METHOD : PUT
     * PATH   : /api/tests/{testId}
     * RESPONSE : Updated Test object
     */
    @PutMapping("/{testId}")
    public ResponseEntity<Test> updateTestResult(@PathVariable int testId,
                                                 @RequestParam String result,
                                                 @RequestParam String status) {
        Test updatedTest = testService.updateTestResult(testId, result, status);
        return ResponseEntity.ok(updatedTest);
    }

    /*
     * AIM    : Add a new test for an appointment
     * METHOD : POST
     * PATH   : /api/tests/{appointmentId}
     * RESPONSE : Created Test object
     */
    @PostMapping("/{appointmentId}")
    public ResponseEntity<Test> addTest(@PathVariable int appointmentId, @RequestBody Test test) {
        Test savedTest = testService.addTest(appointmentId, test);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTest);
    }
}