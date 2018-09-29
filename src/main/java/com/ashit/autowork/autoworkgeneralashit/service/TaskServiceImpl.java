package com.ashit.autowork.autoworkgeneralashit.service;

import java.util.Stack;

import org.springframework.stereotype.Component;

import com.ashit.autowork.autoworkgeneralashit.exceptions.ValidationErrorDetails;
import com.ashit.autowork.autoworkgeneralashit.exceptions.ValidationException;
import com.ashit.autowork.autoworkgeneralashit.utils.Constants;

@Component
public class TaskServiceImpl implements TaskService {

	@Override
	public boolean isBracketInputBalanced(String input) {
		//boolean isBalanced = false;
		if(input == null || input.length() < 1 || input.length() > 100) {
			throw new ValidationException(new ValidationErrorDetails(Constants.VALIDATION_LOCATION, Constants.VALIDATION_PARAM,
					Constants.VALIDATION_LENGTH_MSG_1 + "100" + Constants.VALIDATION_LENGTH_MSG_2, ""));
		}
		
		if(input.length()%2 != 0) {
			return false;
		}
		
		Stack<Character> charStack = new Stack<>(); 
		char[] charArray = input.toCharArray();
		
		for(int i= 0; i < charArray.length; i++) {
			char charToBeChecked = charArray[i];
			if(charToBeChecked == '(' || charToBeChecked == '{' || charToBeChecked == '[') {
				charStack.push(charToBeChecked);
			} else if(charToBeChecked == ')' || charToBeChecked == '}' || charToBeChecked == ']') {
				if(charStack.isEmpty() || !isBracketMatching(charStack.pop(), charToBeChecked)) {
					return false;
				} 
			} else {
				return false;
			}
			
		}
		
		if(!charStack.isEmpty()) {
			return false;
		}
		return true;
	}

	private boolean isBracketMatching(char br1, char br2) {
		return (br1 == '(' && br2 == ')') || (br1 == '{' && br2 == '}') || (br1 == '[' && br2 == ']') ?  true :  false;

	}
	
}
