package com.criticalpath.cpm.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.criticalpath.cpm.entities.ProjectData;
import com.criticalpath.cpm.repositories.ProjectDataRepository;

@Component
public class ProjectDaoImpl implements ProjectDao{

	@Autowired
	ProjectDataRepository projectDataRepository;
	
	@Transactional
	@Override
	public void saveProject(ProjectData projectData) {
		
		projectDataRepository.save(projectData);
	}

	@Override
	public List<ProjectData> getProjects() {

		return projectDataRepository.findAll();
	}

	@Override
	public ProjectData getProject(Long id) {
		Optional<ProjectData> data = projectDataRepository.findById(id);
		return data.get();
	}

}
