package com.criticalpath.cpm.request;

import java.util.List;

import com.criticalpath.cpm.models.ProjectModel;
import com.criticalpath.cpm.models.TaskModel;

public class ProjectRequest {

	private ProjectModel project;
	
	private List<TaskModel> tasks;

	public ProjectModel getProject() {
		return project;
	}

	public void setProject(ProjectModel project) {
		this.project = project;
	}

	public List<TaskModel> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskModel> tasks) {
		this.tasks = tasks;
	}


}
