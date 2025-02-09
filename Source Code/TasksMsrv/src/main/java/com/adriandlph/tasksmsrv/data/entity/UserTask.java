
package com.adriandlph.tasksmsrv.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

/**
 *
 * @author adriandlph
 *
 */
@Entity
@Table(name = "user_task")
public class UserTask {
	// PK
	@EmbeddedId
	private UserTaskPK id;
	// Columns
	@Column(name = "user_id", nullable = false)
	private Long userId;
	// FKs
	@JoinColumn(name = "task_id", referencedColumnName = "id", nullable = false)
	@ManyToOne
	private Task task;
	
	public UserTask() {
	}
	
	public UserTask(UserTaskPK id) {
		this.id = id;
	}

	public UserTaskPK getId() {
		return id;
	}

	public void setId(UserTaskPK id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 23 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		
		if (!(obj instanceof UserTask other)) return false;
		
		if (!Objects.equals(this.id, other.id)) return false;
		if (!Objects.equals(this.userId, other.userId)) return false;
		return Objects.equals(this.task, other.task);
	}

	@Override
	public String toString() {
		StringBuilder str;
		
		str = new StringBuilder("UserTask{");
		str.append(" id=");
		str.append(id);
		str.append(", userId=");
		str.append(userId);
		str.append(", task=");
		str.append(Objects.toString(task));
		str.append(" }");
		
		return str.toString();
	}	
	
}
