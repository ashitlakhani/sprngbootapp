package com.ashit.autowork.autoworkgeneralashit;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.ashit.autowork.autoworkgeneralashit.bean.ToDoItemAddRequest;
import com.ashit.autowork.autoworkgeneralashit.dao.TodoItemRepository;
import com.ashit.autowork.autoworkgeneralashit.entity.TodoItem;
import com.ashit.autowork.autoworkgeneralashit.exceptions.NotFoundException;
import com.ashit.autowork.autoworkgeneralashit.exceptions.ValidationException;
import com.ashit.autowork.autoworkgeneralashit.service.TodoServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {

	@InjectMocks
	TodoServiceImpl todoService;
	

	@Mock
	TodoItemRepository rep;
	
	
	@Before
    public void setUp() throws Exception {

         MockitoAnnotations.initMocks(this);
    }
	
	@Test(expected=ValidationException.class)
	public void testValidationExceptionWhileAddingTodo() {
		ToDoItemAddRequest req = new ToDoItemAddRequest();
		req.setText("Text to be addedText to be addedText to be addedText to be addedText to be addedText to be addedText to be addedText to be added")	;
		todoService.createTodoItem(req);
		
	}
	
	
	@Test
	public void testSuccessfullyFetchingTodoByid() {
		String dateTime = LocalDateTime.now().toString();
		TodoItem ti = new TodoItem(1,"Awesome",false,dateTime);
		Optional<TodoItem> opt = Optional.of(ti);
		when(rep.findById(1)).thenReturn(opt);
		assertTrue(todoService.getTodoById(1).getId() == ti.getId());
		
	}
	
	@Test(expected=NotFoundException.class)
	public void testFailingToFetchTodoByidAsIdDoesNotExist() {
		Optional<TodoItem> opt = Optional.empty();
		when(rep.findById(1)).thenReturn(opt);
		todoService.getTodoById(1).getId();
	}
	

	
}
