
package com.adriandlph.tasksmsrv.data.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;

/**
 *
 * @author adriandlph
 *
 */
@JsonRootName(value = "tasks")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonTypeName("tasks")
@JsonPropertyOrder({ "tasks" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TasksModel {
	@JsonProperty("tasks")
	private List<TaskModel> tasks;
	
	public TasksModel() {
	}

	public List<TaskModel> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskModel> tasks) {
		this.tasks = tasks;
	}
	
}
