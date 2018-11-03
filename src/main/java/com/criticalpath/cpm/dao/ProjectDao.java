package com.criticalpath.cpm.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.criticalpath.cpm.entities.ProjectData;

@Component
public interface ProjectDao {

	public void saveProject(ProjectData projectData);
	
	public List<ProjectData> getProjects();
	
	public ProjectData getProject(Long id);
}
