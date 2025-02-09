
package com.adriandlph.tasksmsrv.logic;

import com.adriandlph.msrv.data.model.ValidationResult;
import com.adriandlph.tasksmsrv.data.entity.Task;
import com.adriandlph.tasksmsrv.data.model.TaskModel;
import java.util.Calendar;

/**
 *
 * @author adriandlph
 *
 */
public class TasksUtils {
	public static TaskModel Task2TaskModel(Task task) {
		TaskModel model;
		
		model = new TaskModel();
		model.setId(task.getId());
		model.setName(task.getName());
		model.setDescription(task.getDescription());
		model.setStart(task.getStart());
		model.setStop(task.getStop());
		
		return model;
	}
	
	public static ValidationResult IsValidTaskName(String name) {		
		if (name == null) return ValidationResult.notValid("Name must be defined.");
		if (name.isBlank()) return ValidationResult.notValid("Name connot be empty.");
		
		return ValidationResult.valid();
	}
	
	public static ValidationResult IsValidTaskDescription(String description) {		
		// Always valid
		return ValidationResult.valid();
	}
	
	public static ValidationResult IsValidTaskStartStop(Calendar start, Calendar stop) {
		// Both defined or both not defined but never one defined and the other not.
		if (start == null && stop == null) return ValidationResult.valid();
		if (start == null || stop == null) return ValidationResult.notValid("Incoherence in start/stop times.");
		
		if (start.after(stop)) return ValidationResult.notValid("Start time cannot be after stop time.");
		
		return ValidationResult.valid();
	}
	
	
}
