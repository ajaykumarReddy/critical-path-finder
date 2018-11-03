package com.criticalpath.cpm.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project_data")
public class ProjectData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String descrption;

	@OneToMany(mappedBy = "projectData")
	private List<TaskData> taskData = new ArrayList<TaskData>();
	
	
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

	public String getDescrption() {
		return descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	public List<TaskData> getTaskData() {
		return taskData;
	}

	public void setTaskData(List<TaskData> taskData) {
		this.taskData = taskData;
	}
	
}
