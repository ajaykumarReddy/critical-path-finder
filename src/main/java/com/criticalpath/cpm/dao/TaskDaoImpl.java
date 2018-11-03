package com.criticalpath.cpm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.criticalpath.cpm.entities.TaskData;
import com.criticalpath.cpm.repositories.TaskDataRepository;

@Component
public class TaskDaoImpl implements TaskDao {
	
	@Autowired
	TaskDataRepository taskDataRepository;

	@Transactional
	@Override
	public void saveTasks(List<TaskData> taskList) {
	
		List<TaskData> result = taskDataRepository.saveAll(taskList);
		
	}

}
