package Service;

import java.util.List;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import Repository.Task;
import Repository.TaskRepository;
import Repository.TaskRepositoryImpl;
import vo.LoginDetails;

public class TaskServiceImpl implements TaskService {
	private TaskRepository repository=new TaskRepositoryImpl<AttributeValue>();
	@Override
	public List<Task> ListAllTasks(){
		return repository.getTasks();
	}
	@Override
	public boolean validateCredentails(LoginDetails Request) {
		// TODO Auto-generated method stub
		return repository.validateCred(Request);
	}

}
