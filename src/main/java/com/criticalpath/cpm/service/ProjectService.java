package com.criticalpath.cpm.service;

import org.springframework.stereotype.Component;

import com.criticalpath.cpm.entities.ProjectData;
import com.criticalpath.cpm.request.ProjectRequest;
import com.criticalpath.cpm.response.ProjectResponse;

@Component
public interface ProjectService {
	
	public void create(ProjectRequest projectRequest);
	
	public ProjectResponse getProjects();
	
	public ProjectData calculateProjectTime(Long id);

}
