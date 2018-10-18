package com.amazonaws.lambda.demo;

import java.util.Iterator;
import java.util.List;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import Repository.Task;
import Service.TaskService;
import Service.TaskServiceImpl;

public class LambdaFunctionHandler implements RequestHandler<Request, Response> {

    
    private TaskService taskService;
	@Override
    public Response handleRequest(Request Request, Context context) {
    	Response rep = new Response();
    	taskService= new TaskServiceImpl();
    	try {
        	
        	System.out.println(Request);
        	//if(taskService.validateCredentails(Request)){
        		//System.out.println("Here");
        		
            List<Task> tasks=taskService.ListAllTasks();
            String request = "Buddy";
            
            Iterator itr = tasks.iterator();
            String value = "";
            
            while(itr.hasNext()) {	
            	Task task =(Task)itr.next();
            	Item item=task.getItem();
            	value= (String)item.get(request);
            }
            
            rep.setStatusCode(200);
            rep.setRetrieve(value);         
            
            return rep;
            
        } catch (Exception e) {
        	rep.setStatusCode(500);
        	rep.setRetrieve(e.getMessage());
        	e.printStackTrace();
        	
        }

        return rep;
    }
       
    }


