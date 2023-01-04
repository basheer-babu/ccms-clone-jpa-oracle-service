package com.javatechie.crud.example.entity;

public class TaskCreationResponseEntity {
	
	private String id;
	private String definitionId;
	private String businessKey;
	private String caseInstanceId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDefinitionId() {
		return definitionId;
	}
	public void setDefinitionId(String definitionId) {
		this.definitionId = definitionId;
	}
	public String getBusinessKey() {
		return businessKey;
	}
	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}
	public String getCaseInstanceId() {
		return caseInstanceId;
	}
	public void setCaseInstanceId(String caseInstanceId) {
		this.caseInstanceId = caseInstanceId;
	}
	@Override
	public String toString() {
		return "TaskCreationResponseEntity [id=" + id + ", definitionId=" + definitionId + ", businessKey="
				+ businessKey + ", caseInstanceId=" + caseInstanceId + "]";
	}
	
	
	

}
