
package com.adriandlph.tasksmsrv.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author adriandlph
 *
 */
@Entity
@Table(name = "task")
public class Task {
	public static final int NAME_LEN = 255;
	public static final int DESCRIPTION_LEN = 2048;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name", length = NAME_LEN, nullable = false)
	private String name;
	@Column(name = "description", length = DESCRIPTION_LEN)
	private String description = null;
	@Column(name = "start", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar start;
	@Column(name = "stop", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar stop;

	public Task() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getStart() {
		return start;
	}

	public void setStart(Calendar start) {
		this.start = start;
	}

	public Calendar getStop() {
		return stop;
	}

	public void setStop(Calendar stop) {
		this.stop = stop;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 71 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		
		if (!(obj instanceof Task other)) return false;
		
		if (!Objects.equals(this.id, other.id)) return false;
		if (!Objects.equals(this.name, other.name)) return false;
		if (!Objects.equals(this.description, other.description)) return false;
		if (!Objects.equals(this.start, other.start)) return false;
		return Objects.equals(this.stop, other.stop);
	}
	
}
