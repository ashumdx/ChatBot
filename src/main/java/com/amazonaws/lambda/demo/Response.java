package com.amazonaws.lambda.demo;

import java.util.Map;

import com.amazonaws.services.dynamodbv2.document.Item;

public class Response {
	private String retrieve;
	private Integer statusCode;
	

	public Response(String retrieve, Integer statusCode) {
		super();
		this.retrieve = retrieve;
		this.statusCode = statusCode;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public Response() {}
	
	public Response(String retrieve) {
		super();
		this.retrieve = retrieve;
	}

	public String getRetrieve() {
		return retrieve;
	}

	public void setRetrieve(String retrieve) {
		this.retrieve = retrieve;
	}
	
	
	

}
