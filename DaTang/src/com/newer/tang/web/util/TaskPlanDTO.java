package com.newer.tang.web.util;

import java.util.Date;

import javax.ejb.Timeout;

import org.springframework.format.annotation.DateTimeFormat;

public class TaskPlanDTO {
	private Integer taskId;
	private String planName;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date beginDate1;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date beginDate2;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate1;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate2;
	private String isFeedback;
	public TaskPlanDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaskPlanDTO(Integer taskId, String planName, Date beginDate1,
			Date beginDate2, Date endDate1, Date endDate2, String isFeedback) {
		super();
		this.taskId = taskId;
		this.planName = planName;
		this.beginDate1 = beginDate1;
		this.beginDate2 = beginDate2;
		this.endDate1 = endDate1;
		this.endDate2 = endDate2;
		this.isFeedback = isFeedback;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public Date getBeginDate1() {
		return beginDate1;
	}
	public void setBeginDate1(Date beginDate1) {
		this.beginDate1 = beginDate1;
	}
	public Date getBeginDate2() {
		return beginDate2;
	}
	public void setBeginDate2(Date beginDate2) {
		this.beginDate2 = beginDate2;
	}
	public Date getEndDate1() {
		return endDate1;
	}
	public void setEndDate1(Date endDate1) {
		this.endDate1 = endDate1;
	}
	public Date getEndDate2() {
		return endDate2;
	}
	public void setEndDate2(Date endDate2) {
		this.endDate2 = endDate2;
	}
	public String getIsFeedback() {
		return isFeedback;
	}
	public void setIsFeedback(String isFeedback) {
		this.isFeedback = isFeedback;
	}
	@Override
	public String toString() {
		return "TaskPlanDTO [taskId=" + taskId + ", planName=" + planName
				+ ", beginDate1=" + beginDate1 + ", beginDate2=" + beginDate2
				+ ", endDate1=" + endDate1 + ", endDate2=" + endDate2
				+ ", isFeedback=" + isFeedback + "]";
	}
	
}
