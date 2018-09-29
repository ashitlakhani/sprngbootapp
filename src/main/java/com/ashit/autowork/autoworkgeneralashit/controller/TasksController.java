package com.ashit.autowork.autoworkgeneralashit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashit.autowork.autoworkgeneralashit.bean.BalanceTestResult;
import com.ashit.autowork.autoworkgeneralashit.service.TaskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path="/tasks")
@Api(value="Tasks", description="General Algorithmic Tasks")
public class TasksController {

	@Autowired
	private TaskService taskService;
	
	
	@GetMapping(path="/validateBrackets")
	@ApiOperation(value="Check if brackets in a string are balanced", response=BalanceTestResult.class, produces="application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="OK"),
			@ApiResponse(code = 400, message="Validation Error")
			})
	@ApiParam(name="input", required=true, value="Input string (max length 100)")
	public ResponseEntity<BalanceTestResult> validateIfBracketsAreBalanced(@RequestParam String input) {
		
		BalanceTestResult bean = new BalanceTestResult();
		bean.setInput(input);
		bean.setBalanced(taskService.isBracketInputBalanced(input.trim()));
		
		ResponseEntity<BalanceTestResult> re = new ResponseEntity<>(bean, HttpStatus.OK);
		
		return re;
	}
}
