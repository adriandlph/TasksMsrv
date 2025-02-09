
package com.adriandlph.tasksmsrv.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.Objects;

/**
 *
 * @author adriandlph
 *
 */
@Embeddable
public class UserTaskPK {
	@Column(name = "user_id", insertable=false, updatable=false)
	private Long userId;
	@Column(name = "task_id", insertable=false, updatable=false)
	private Long taskId;

	public UserTaskPK() {
	}

	public UserTaskPK(Long userId, Long taskId) {
		this.userId = userId;
		this.taskId = taskId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 89 * hash + Objects.hashCode(this.userId);
		hash = 89 * hash + Objects.hashCode(this.taskId);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		
		if (!(obj instanceof UserTaskPK other)) return false;
		
		if (!Objects.equals(this.userId, other.userId)) return false;
		return Objects.equals(this.taskId, other.taskId);
	}

	@Override
	public String toString() {
		StringBuilder str;
		
		str = new StringBuilder("UserTaskPK{");
		str.append(" userId=");
		str.append(userId);
		str.append(", taskId");
		str.append(taskId);
		str.append(" }");
		
		return str.toString();
	}
	
}
