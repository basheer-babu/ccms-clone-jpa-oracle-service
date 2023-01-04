package com.javatechie.crud.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CCMS_DEMO_TASK_DATA")
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String case_ref_no;
    private String court_order_id;
    private String request_type;
    private String court_name;
    private String court_order_date;
    private String maker_name;
    private String checker_name;
    private String defendant_type;
    
    private String processId;
    private String definition_Id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCase_ref_no() {
		return case_ref_no;
	}
	public void setCase_ref_no(String case_ref_no) {
		this.case_ref_no = case_ref_no;
	}
	public String getCourt_order_id() {
		return court_order_id;
	}
	public void setCourt_order_id(String court_order_id) {
		this.court_order_id = court_order_id;
	}
	public String getRequest_type() {
		return request_type;
	}
	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}
	public String getCourt_name() {
		return court_name;
	}
	public void setCourt_name(String court_name) {
		this.court_name = court_name;
	}
	public String getCourt_order_date() {
		return court_order_date;
	}
	public void setCourt_order_date(String court_order_date) {
		this.court_order_date = court_order_date;
	}
	public String getMaker_name() {
		return maker_name;
	}
	public void setMaker_name(String maker_name) {
		this.maker_name = maker_name;
	}
	public String getChecker_name() {
		return checker_name;
	}
	public void setChecker_name(String checker_name) {
		this.checker_name = checker_name;
	}
	public String getDefendant_type() {
		return defendant_type;
	}
	public void setDefendant_type(String defendant_type) {
		this.defendant_type = defendant_type;
	}
	
	public String getDefinition_Id() {
		return definition_Id;
	}
	public void setDefinition_Id(String definition_Id) {
		this.definition_Id = definition_Id;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", case_ref_no=" + case_ref_no + ", court_order_id=" + court_order_id
				+ ", request_type=" + request_type + ", court_name=" + court_name + ", court_order_date="
				+ court_order_date + ", maker_name=" + maker_name + ", checker_name=" + checker_name
				+ ", defendant_type=" + defendant_type + ", processId=" + processId + ", definition_Id=" + definition_Id
				+ "]";
	}
	
    
	
    
}
