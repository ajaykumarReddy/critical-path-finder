package com.criticalpath.cpm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.criticalpath.cpm.business.Project;
import com.criticalpath.cpm.business.Task;
import com.criticalpath.cpm.dao.ProjectDao;
import com.criticalpath.cpm.dao.TaskDao;
import com.criticalpath.cpm.entities.ProjectData;
import com.criticalpath.cpm.entities.TaskData;
import com.criticalpath.cpm.models.DataModel;
import com.criticalpath.cpm.models.ProjectModel;
import com.criticalpath.cpm.models.TaskModel;
import com.criticalpath.cpm.request.ProjectRequest;
import com.criticalpath.cpm.response.ProjectResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDao projectDao;
	
	@Autowired
	TaskDao taskDao;
	
	@Override
	public void create(ProjectRequest projectRequest) {
		ObjectMapper mapper = new ObjectMapper();
		
		ProjectData projectData = mapper.convertValue(projectRequest.getProject(), ProjectData.class);
		List<TaskData> taskData = mapper.convertValue(projectRequest.getTasks(), new TypeReference<List<TaskData>>(){});
		
		List<TaskData> taskList = new ArrayList<TaskData>();
		for(TaskData data:taskData){
			data.setProjectData(projectData);
			taskList.add(data);
		}
		projectData.setTaskData(taskList);
		projectDao.saveProject(projectData);
		taskDao.saveTasks(taskList);
	}

	@Override
	public ProjectResponse getProjects() {
		ObjectMapper mapper = new ObjectMapper();
		List<ProjectData> projectList =  projectDao.getProjects();
		ProjectResponse response = new ProjectResponse();
		List<DataModel> modelList = new ArrayList<DataModel>();
		if(!CollectionUtils.isEmpty(projectList)){
			for(ProjectData data:projectList){
				DataModel model= new DataModel();
				ProjectModel projectModel = new ProjectModel();
				projectModel.setId(data.getId());
				projectModel.setName(data.getName());
				projectModel.setDescrption(data.getDescrption());
				List<TaskModel> taskModelList = new ArrayList<TaskModel>();
				for(TaskData taskData:data.getTaskData()){
					TaskModel taskModel = new TaskModel();
					taskModel.setId(taskData.getId());
					taskModel.setName(taskData.getName());
					taskModel.setDuration(taskData.getDuration());
					taskModel.setPrerequisites(taskData.getPrerequisites());
					taskModelList.add(taskModel);
				}
				model.setProjectModel(projectModel);
				model.setTaskModel(taskModelList);
				modelList.add(model);
			}
			response.setDataModel(modelList);
		}
		
		return response;
	}

	@Override
	public ProjectData calculateProjectTime(Long id) {
		
		ProjectData data = projectDao.getProject(id);
		if(data != null && !CollectionUtils.isEmpty(data.getTaskData())){
			Project project = new Project();
			for(TaskData entry:data.getTaskData()){
				Task task = new Task(entry.getName(),entry.getDuration());
				if(entry.getPrerequisites()!=null && !"".equals(entry.getPrerequisites())){
					StringTokenizer tokenizer = new StringTokenizer(entry.getPrerequisites(), ",");
					while (tokenizer.hasMoreTokens()) {
			            //task.dependsOn(project.tokenizer.nextToken().toString());
			        }  
				}
				project.addTask(task);
			}
			System.out.println("-------------"+project.calculateTimeToDelivery());
			System.out.println("-------------"+project.calculateCriticalPath());
		}
		return data;
	}

	
}
