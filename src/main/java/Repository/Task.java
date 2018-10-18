package Repository;

import com.amazonaws.services.dynamodbv2.document.Item;

public class Task {
	private String TaskId;
	private Item item;

	public Task() {

	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getTaskId() {
		return TaskId;
	}

	public void setTaskId(String taskId) {
		TaskId = taskId;
	}

	public Task(String taskId) {
		super();
		TaskId = taskId;
	}

}
