package com.ashit.autowork.autoworkgeneralashit.service;

import org.springframework.stereotype.Service;

@Service
public interface TaskService {

	/**
	 * this is method is used to check if the brackets in the input are balanced
	 * 
	 * @param input is the input string 
	 * @return <code>true</code> if brackets balanced else will return <code>false</code>
	 */
	boolean isBracketInputBalanced(String input);
	
}
