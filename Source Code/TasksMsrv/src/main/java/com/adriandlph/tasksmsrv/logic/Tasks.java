
package com.adriandlph.tasksmsrv.logic;

import com.adriandlph.msrv.data.model.ValidationResult;
import com.adriandlph.msrv.exception.NotValidException;
import com.adriandlph.tasksmsrv.data.entity.Task;
import com.adriandlph.tasksmsrv.data.entity.UserTask;
import com.adriandlph.tasksmsrv.data.entity.UserTaskPK;
import com.adriandlph.tasksmsrv.data.model.TaskModel;
import com.adriandlph.tasksmsrv.exception.CreateTaskException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author adriandlph
 *
 */
@Service
public class Tasks {
	@Autowired
	private EntityManager em;
	
	@Transactional
	public Task createTask(TaskModel taskModel, Long userId) throws NotValidException, CreateTaskException {
		Task task;
		UserTask userTask;
		ValidationResult validationResult;
		Query query;
		
		// Validate if the model is defined
		if (taskModel == null) throw new NotValidException(1, "Task not defined.");
		if (userId == null)  throw new NotValidException(1, "User ID not defined.");
		
		// Validate name
		if (!(validationResult = TasksUtils.IsValidTaskName(taskModel.getName())).isValid()) {
			throw new NotValidException(2, validationResult.getReason());
		}
		
		// Validate description
		if (!(validationResult = TasksUtils.IsValidTaskDescription(taskModel.getDescription())).isValid()) {
			throw new NotValidException(3, validationResult.getReason());
		}
		
		// Validate start and stop time
		if (taskModel.getStart() == null && taskModel.getStop() != null) taskModel.setStart(Calendar.getInstance());
		if (!(validationResult = TasksUtils.IsValidTaskStartStop(taskModel.getStart(), taskModel.getStop())).isValid()) {
			throw new NotValidException(4, validationResult.getReason());
		}
		
		task = new Task();
		task.setName(taskModel.getName());
		task.setDescription(taskModel.getDescription());
		task.setStart(taskModel.getStart());
		task.setStop(taskModel.getStop());
		em.persist(task);
		
		userTask = new UserTask(new UserTaskPK(userId, task.getId()));
		userTask.setUserId(userId);
		userTask.setTask(task);
		em.persist(userTask);
		
		em.flush();
		
		return task;
	}
	
	public List<Task> getAllUserTasks(Long userId) {
		Query query;
		
		if (1 == 1) {
			List<Task> list = new ArrayList<>();
			for (int i  = 1; i <= 10; i++) {
				Task t = new Task();
				t.setId(Integer.valueOf(i).longValue());
				t.setName("Task " + i);
				t.setDescription("Description " + i);
				t.setStart(Calendar.getInstance());
				t.setStop(Calendar.getInstance());
				list.add(t);
			}
			
			return list;
		}
		
		query = em.createQuery("SELECT us.task FROM UserTask us WHERE us.userId = :userId");
		query.setParameter("userId", userId);
		
		return query.getResultList();
	}
}
