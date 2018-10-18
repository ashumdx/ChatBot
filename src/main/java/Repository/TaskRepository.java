package Repository;

import java.util.List;

import com.amazonaws.lambda.demo.Request;

import vo.LoginDetails;

public interface TaskRepository {
	public List<Task> getTasks();
	public boolean validateCred(LoginDetails Request);
	
}
