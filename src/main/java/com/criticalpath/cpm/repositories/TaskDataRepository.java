package com.criticalpath.cpm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.criticalpath.cpm.entities.TaskData;

public interface TaskDataRepository extends JpaRepository<TaskData, Long> {

}
