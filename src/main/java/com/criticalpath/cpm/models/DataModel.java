package com.criticalpath.cpm.models;

import java.util.List;

public class DataModel {
	
	private ProjectModel projectModel;
	private List<TaskModel> taskModel;
	
	public ProjectModel getProjectModel() {
		return projectModel;
	}
	public void setProjectModel(ProjectModel projectModel) {
		this.projectModel = projectModel;
	}
	public List<TaskModel> getTaskModel() {
		return taskModel;
	}
	public void setTaskModel(List<TaskModel> taskModel) {
		this.taskModel = taskModel;
	}

}
