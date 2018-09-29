package com.ashit.autowork.autoworkgeneralashit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.ashit.autowork.autoworkgeneralashit.exceptions.ValidationException;
import com.ashit.autowork.autoworkgeneralashit.service.TaskServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {

	@InjectMocks
	TaskServiceImpl taskService;
	
	
	@Test
	public void testIfStringBalanced() {
		assertTrue(taskService.isBracketInputBalanced("({[]})"));
		assertTrue(taskService.isBracketInputBalanced("{}[]()"));
		assertTrue(taskService.isBracketInputBalanced("[{()()}({[]})]({}[({})])((((((()[])){}))[]{{{({({({{{{{{}}}}}})})})}}}))[][][]"));
	}
	
	@Test
	public void testIfStringUnBalanced() {
		assertFalse(taskService.isBracketInputBalanced("("));
		assertFalse(taskService.isBracketInputBalanced("{}[]()( "));
		assertFalse(taskService.isBracketInputBalanced("(({[()}])("));
		assertFalse(taskService.isBracketInputBalanced("[{()()}({[]})]({}[({})])((((((()[])){}))[]{{{({({({{{{{{}}}}}})})})}}}))[][][]{"));
		assertFalse(taskService.isBracketInputBalanced("}"));
		assertFalse(taskService.isBracketInputBalanced("{[()}]"));
	}
	
	@Test(expected=ValidationException.class)
	public void testIfValidationExceptionThrownOnInvalidInput() { 		
		taskService.isBracketInputBalanced(null);
	}
	
}
