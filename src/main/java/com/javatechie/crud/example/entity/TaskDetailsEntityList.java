package com.javatechie.crud.example.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskDetailsEntityList {
	
	
	private TaskDetailsEntity[] taskDetailsEntity;

	public TaskDetailsEntity[] getTaskDetailsEntity() {
		return taskDetailsEntity;
	}

	public void setTaskDetailsEntity(TaskDetailsEntity[] taskDetailsEntity) {
		this.taskDetailsEntity = taskDetailsEntity;
	}

	

}
