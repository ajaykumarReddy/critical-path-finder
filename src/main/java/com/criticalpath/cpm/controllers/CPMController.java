package com.criticalpath.cpm.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.criticalpath.cpm.request.ProjectRequest;
import com.criticalpath.cpm.response.ProjectResponse;
import com.criticalpath.cpm.service.ProjectService;

@RestController
//RequestMapping("/api/v1/cpm")
public class CPMController {
	
	/*@Autowired
	ProjectDataRepository projectDataRepository;*/
	
	@Autowired
	ProjectService projectService;
/**
 * {"project":{"name":"project1","descrption":"Sample project1"},"tasks":[{"name":"task1","completeTime":"10","dependsOn":""},{"name":"task1","completeTime":"10","dependsOn":""}]}
 * @param servletRequest
 * @param projectRequest
 */
	@PostMapping("/create")
	public void createProject(HttpServletRequest servletRequest,@RequestBody ProjectRequest projectRequest){
		projectService.create(projectRequest);
	}
	
	@GetMapping("/projects")
	public ProjectResponse getProjects(){
		ProjectResponse response= projectService.getProjects();
		return response;
	}
	
	@GetMapping("/project/{id}")
	public void calculateProjectTime(@PathVariable("id") Long id){
		projectService.calculateProjectTime(id);
	}
}
