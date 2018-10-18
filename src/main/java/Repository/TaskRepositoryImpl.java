package Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.amazonaws.lambda.demo.Response;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import Constants.MasterDataConstants;
import Constants.PropertyConstants;
import vo.LoginDetails;

public class TaskRepositoryImpl<AttributeValue> implements TaskRepository {
	static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
	static DynamoDB dynamoDB = new DynamoDB(client);
	static String credtableName= "Buddy";
	
	@Override
	public List<Task>  getTasks() {
	/*	List<Task> tasks=new ArrayList<Task>();
		try {
			ScanRequest scanRequest=new ScanRequest().withTableName(MasterDataConstants.TASK_TABLE_NAME);
			ScanResult result = client.scan(scanRequest);
			for (Map<String, String> item : result.getItems()){
				System.out.println(item);
				System.out.println(item.);
				Task task=new Task();
				task.setTaskId(String.valueOf(item.get(PropertyConstants.ID).getS()));
				tasks.add(task);
			}
	}catch (Exception e) {
        System.err.println("Get items failed.");
        System.err.println(e.getMessage());

    }	
	return tasks;*/
		List<Task> tasks=new ArrayList<Task>();
		Task task = null;
		Item item= null;
		Table table = dynamoDB.getTable(MasterDataConstants.TASK_TABLE_NAME);
		 ScanSpec scanSpec = new ScanSpec().withProjectionExpression("Buddy");
		 
		try{
			  ItemCollection<ScanOutcome> items = table.scan(scanSpec);
			  
			System.out.println(items.toString());
			 Iterator<Item> iter = items.iterator();
	            while (iter.hasNext()) {
	            	task = new Task();
	                item = iter.next();
	                System.out.println("item->"+item);
	                System.out.println(item.get("Buddy"));
	                task.setItem(item);
	                tasks.add(task);
	            }
			/*ObjectMapper mapper = new ObjectMapper();
			task = mapper.readValue(item.toJSON(), Task.class);
	        System.out.println("readValue = " + task);*/
		}catch (Exception e) {
            System.err.println("Get item failed.");
            System.err.println(e.getMessage());

        }
	
	return tasks;
}

	@Override
	public boolean validateCred(LoginDetails Request) {
		// TODO Auto-generated method stub
		return false;
	}


	
	/*
	@Override
	public boolean validateCred(LoginDetails Request) {
		//Table table = dynamoDB.getTable(credtableName);
	try{

			Request.setName("ashumdx@gmail.com");
			Request.setPassword("Pass.demo123#");
			ScanRequest scanRequest = new ScanRequest()
				    .withTableName(credtableName);
				ScanResult result = client.scan(scanRequest);
				for (Map<String, com.amazonaws.services.dynamodbv2.model.AttributeValue> item : result.getItems()){
					System.out.println(item);
					if(null!=Request.getName() && 
							String.valueOf(item.get(PropertyConstants.NAME).getS()).
							equalsIgnoreCase(Request.getName())){
						System.out.println("Present");
						return true;
					}
						
				}
		}catch (Exception e) {
            System.err.println("Get item failed.");
            System.err.println(e.getMessage());

        }	
		return false;
	}*/
			
		
		
		
}	
	


