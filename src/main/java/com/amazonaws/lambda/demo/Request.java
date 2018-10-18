package com.amazonaws.lambda.demo;

public class Request {
private String name;
public Request() {}


public Request(String name) {
	super();
	this.name = name;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

}
