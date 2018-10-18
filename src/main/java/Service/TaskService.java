package Service;

import java.util.ArrayList;
import java.util.List;

import Repository.Task;
import vo.LoginDetails;

public interface TaskService {
	 

	public List<Task> ListAllTasks();
	public boolean validateCredentails(LoginDetails Request);
}
