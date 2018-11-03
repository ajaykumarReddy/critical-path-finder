package com.criticalpath.cpm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.criticalpath.cpm.entities.ProjectData;

public interface ProjectDataRepository extends JpaRepository<ProjectData, Long> {

}
