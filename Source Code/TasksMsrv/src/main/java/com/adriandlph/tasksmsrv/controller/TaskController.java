
package com.adriandlph.tasksmsrv.controller;

import com.adriandlph.msrv.data.model.Response;
import com.adriandlph.tasksmsrv.App;
import com.adriandlph.tasksmsrv.data.model.TaskModel;
import com.adriandlph.tasksmsrv.data.model.TasksModel;
import com.adriandlph.tasksmsrv.logic.Tasks;
import com.adriandlph.tasksmsrv.logic.TasksUtils;
import jakarta.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author adriandlph
 *
 */
@RestController
@RequestMapping(path = App.BASE_PATH + "/task")
public class TaskController {
	private static final Logger LOG = LoggerFactory.getLogger(TaskController.class);
	
	@Autowired
	private Tasks tasks;
	
	@GetMapping(path = "/{taskId}")
	public Response<String> getTaskById(@PathParam("taskId") String taskId) {
		return null;
	}
	
	@GetMapping(path = "/")
	public Response<List<TaskModel>> getAllUserTasks(@RequestHeader Map<String, String> headers) {
		List<TaskModel>	tasksList = new ArrayList<>();
		
		for (Map.Entry<String,String> entry : headers.entrySet()) {
			LOG.info("{}: {}", entry.getKey(), entry.getValue());
		}
		
		String authenticationToken = headers.get("authentication");
		
		LOG.info("Token: {}", authenticationToken);
		
		
		tasks.getAllUserTasks(1L).stream()
			.forEach((task) -> tasksList.add(TasksUtils.Task2TaskModel(task)));
		
		
		return Response.Ok(tasksList);
	}
	
	
	
}
