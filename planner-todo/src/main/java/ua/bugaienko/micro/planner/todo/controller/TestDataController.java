package ua.bugaienko.micro.planner.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.bugaienko.micro.planner.todo.service.TestDataService;

/**
 * @author Sergii Bugaienko
 */

@RestController
@RequestMapping("/data")
public class TestDataController {

    private final TestDataService testDataService;

    @Autowired
    public TestDataController(TestDataService testDataService) {
        this.testDataService = testDataService;
    }

    @PostMapping("init")
    public ResponseEntity<Boolean> init(@RequestBody Long userId){

        Boolean bool = testDataService.initTestData(userId);

        return ResponseEntity.ok(bool);
    }

}
