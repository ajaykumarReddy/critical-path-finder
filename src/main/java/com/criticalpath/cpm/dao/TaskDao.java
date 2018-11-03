package com.criticalpath.cpm.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.criticalpath.cpm.entities.TaskData;

@Component
public interface TaskDao {
	
	public void saveTasks(List<TaskData> taskList);

}
