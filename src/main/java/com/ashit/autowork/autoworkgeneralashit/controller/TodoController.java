package com.ashit.autowork.autoworkgeneralashit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashit.autowork.autoworkgeneralashit.bean.ToDoItemAddRequest;
import com.ashit.autowork.autoworkgeneralashit.bean.ToDoItemUpdateRequest;
import com.ashit.autowork.autoworkgeneralashit.bean.TodoItemResponse;
import com.ashit.autowork.autoworkgeneralashit.service.TodoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path="/todo")
@Api(value="TODO", description="Operations related to Todo Items")
public class TodoController {

	@Autowired
	private TodoService service;
	
	@ApiOperation(value="Creates a Todo item", response=TodoItemResponse.class, produces="application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="OK"),
			@ApiResponse(code = 400, message="Validation Error")
			})
	@PostMapping
	public ResponseEntity<TodoItemResponse> createTodoItem(@RequestBody ToDoItemAddRequest body){
		TodoItemResponse res = service.createTodoItem(body);
		
		return new ResponseEntity<TodoItemResponse>(res, HttpStatus.OK);
	}
	
	@ApiOperation(value="fetches a todo item on the basis of the id", response=TodoItemResponse.class, produces="application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="OK"),
			@ApiResponse(code = 404, message="Not Found Error")
			})
	@GetMapping(path="/{id}")
	public ResponseEntity<TodoItemResponse> getTodoById(@PathVariable int id) {
		TodoItemResponse res = service.getTodoById(id);
		return new ResponseEntity<TodoItemResponse>(res, HttpStatus.OK);
	}
	
	@ApiOperation(value="updates a todo item", response=TodoItemResponse.class, produces="application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="OK"),
			@ApiResponse(code = 404, message="Not Found Error"),
			@ApiResponse(code = 400, message="Validation Error")
			})
	@PatchMapping(path="/{id}")
	public ResponseEntity<TodoItemResponse> updateTodo(@PathVariable int id, @RequestBody ToDoItemUpdateRequest body) { 
		TodoItemResponse res = service.updateTodo(id, body);
		return new ResponseEntity<TodoItemResponse>(res, HttpStatus.OK);
	}
}
