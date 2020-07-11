package com.newer.tang.data.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Task {
	private int taskId;
	private String taskName;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date beginDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date realbeginDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date realendDate;
	private String status;
	private Employee implementorId;
	private Integer assignerId;
	private String taskDesc;
	private List<Plan> plan;
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task(int taskId, String taskName, Date beginDate, Date endDate,
			Date realbeginDate, Date realendDate, String status,
			Employee implementorId, Integer assignerId, String taskDesc,
			List<Plan> plan) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.realbeginDate = realbeginDate;
		this.realendDate = realendDate;
		this.status = status;
		this.implementorId = implementorId;
		this.assignerId = assignerId;
		this.taskDesc = taskDesc;
		this.plan = plan;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getRealbeginDate() {
		return realbeginDate;
	}
	public void setRealbeginDate(Date realbeginDate) {
		this.realbeginDate = realbeginDate;
	}
	public Date getRealendDate() {
		return realendDate;
	}
	public void setRealendDate(Date realendDate) {
		this.realendDate = realendDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Employee getImplementorId() {
		return implementorId;
	}
	public void setImplementorId(Employee implementorId) {
		this.implementorId = implementorId;
	}
	public Integer getAssignerId() {
		return assignerId;
	}
	public void setAssignerId(Integer assignerId) {
		this.assignerId = assignerId;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public List<Plan> getPlan() {
		return plan;
	}
	public void setPlan(List<Plan> plan) {
		this.plan = plan;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName
				+ ", beginDate=" + beginDate + ", endDate=" + endDate
				+ ", realbeginDate=" + realbeginDate + ", realendDate="
				+ realendDate + ", status=" + status + ", implementorId="
				+ implementorId + ", assignerId=" + assignerId + ", taskDesc="
				+ taskDesc + ", plan=" + plan + "]";
	}
	
	
}
