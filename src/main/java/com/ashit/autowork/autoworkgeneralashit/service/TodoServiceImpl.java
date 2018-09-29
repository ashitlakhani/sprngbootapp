package com.ashit.autowork.autoworkgeneralashit.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashit.autowork.autoworkgeneralashit.bean.ToDoItemAddRequest;
import com.ashit.autowork.autoworkgeneralashit.bean.ToDoItemUpdateRequest;
import com.ashit.autowork.autoworkgeneralashit.bean.TodoItemResponse;
import com.ashit.autowork.autoworkgeneralashit.dao.TodoItemRepository;
import com.ashit.autowork.autoworkgeneralashit.entity.TodoItem;
import com.ashit.autowork.autoworkgeneralashit.exceptions.NotFoundErrorDetails;
import com.ashit.autowork.autoworkgeneralashit.exceptions.NotFoundException;
import com.ashit.autowork.autoworkgeneralashit.exceptions.ValidationErrorDetails;
import com.ashit.autowork.autoworkgeneralashit.exceptions.ValidationException;
import com.ashit.autowork.autoworkgeneralashit.utils.Constants;

@Component
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoItemRepository rep;
	
	@Override
	public TodoItemResponse createTodoItem(ToDoItemAddRequest input) {
		
		validateTheInputForNoOfCharacters(input.getText());
		
		String currentDateTime = LocalDateTime.now().toString();
		TodoItem todoItemToBePersisted = new TodoItem(input.getText(), false, currentDateTime); 
		return convertEntityToResponse(rep.save(todoItemToBePersisted));
	}

	@Override
	public TodoItemResponse getTodoById(int id) {		
		return convertEntityToResponse(getTodoEntityById(id));
	}
	
	private TodoItem getTodoEntityById(int id) {
		Optional<TodoItem> opt = rep.findById(id);
		if(!opt.isPresent()) {
			throw new NotFoundException(new NotFoundErrorDetails(Constants.NOT_FOUND_VALIDATION_MSG_1 + id + Constants.NOT_FOUND_VALIDATION_MSG_2));
		}
		return opt.get();
	}

	@Override
	public TodoItemResponse updateTodo(int id, ToDoItemUpdateRequest input) {
		if(input.getText()!=null) {
			validateTheInputForNoOfCharacters(input.getText());
		}		
		
		TodoItem entity = getTodoEntityById(id);		
		if(input.getText()!= null && !entity.getText().equals(input.getText())) {
			entity.setText(input.getText());
		}
		if(input.getIsCompleted() != null && entity.isCompleted() != input.getIsCompleted().booleanValue() ) {
			entity.setCompleted(input.getIsCompleted());
		}
		
		return convertEntityToResponse(rep.save(entity));
	}
	
	private void validateTheInputForNoOfCharacters(String text) {
		if(text == null || text.length() < 1 || text.length() > 50) {
			throw new ValidationException(new ValidationErrorDetails(Constants.VALIDATION_LOCATION, Constants.VALIDATION_PARAM,
					Constants.VALIDATION_LENGTH_MSG_1 + "50" + Constants.VALIDATION_LENGTH_MSG_2, ""));
		}
	}

	/**
	 * This method is used to convert the entity to the response object
	 * 
	 * @param entity is the entity to be converted to the response object
	 * @return a response object
	 */
	private TodoItemResponse convertEntityToResponse(TodoItem entity) {
		TodoItemResponse resp = new TodoItemResponse();
		resp.setCompleted(entity.isCompleted());
		resp.setCreatedAt(entity.getCreatedAt());
		resp.setId(entity.getId());
		resp.setText(entity.getText());
		return resp;
	}
	
}
