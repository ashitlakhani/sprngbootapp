package com.ashit.autowork.autoworkgeneralashit.bean;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class BalanceTestResult implements Serializable {
	
	private static final long serialVersionUID = 4302363461028149015L;
	private boolean isBalanced;
	@ApiModelProperty(value="this is the input")
	private String input;
	
	public boolean isBalanced() {
		return isBalanced;
	}
	public void setBalanced(boolean isBalanced) {
		this.isBalanced = isBalanced;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	
	

}
