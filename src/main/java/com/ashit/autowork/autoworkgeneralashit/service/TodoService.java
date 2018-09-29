package com.ashit.autowork.autoworkgeneralashit.service;

import org.springframework.stereotype.Service;

import com.ashit.autowork.autoworkgeneralashit.bean.ToDoItemAddRequest;
import com.ashit.autowork.autoworkgeneralashit.bean.ToDoItemUpdateRequest;
import com.ashit.autowork.autoworkgeneralashit.bean.TodoItemResponse;

@Service
public interface TodoService {

	
	/**
	 * This method is used to create a todo item
	 * @param input is the user input for creating the todo item
	 * @return a response object of type {@link TodoItemResponse} containing the todo data
	 */
	TodoItemResponse createTodoItem(ToDoItemAddRequest input);
	
	/**
	 * This method is used to fetch a todo for a specific id
	 * @param id is the id of the todo to be fetched
	 * @return a response object of type {@link TodoItemResponse} containing the todo data
	 */
	TodoItemResponse getTodoById(int id);
	
	
	/**
	 * This method is used to update the todo object
	 * @param id  is the id of the todo to be updated
	 * @return a response object of type {@link TodoItemResponse} containing the todo data
	 */
	TodoItemResponse updateTodo(int id, ToDoItemUpdateRequest input);
	
}
