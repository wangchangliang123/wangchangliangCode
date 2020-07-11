package com.newer.tang.data.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Plan {
	private Integer planId;
	private String planName;
	private String status;
	private String isFeedback;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date beginDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	private int taskId;
	private String feedbackInfo;
	private String planDesc;
	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Plan(Integer planId, String planName, String status,
			String isFeedback, Date beginDate, Date endDate, int taskId,
			String feedbackInfo, String planDesc) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.status = status;
		this.isFeedback = isFeedback;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.taskId = taskId;
		this.feedbackInfo = feedbackInfo;
		this.planDesc = planDesc;
	}
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIsFeedback() {
		return isFeedback;
	}
	public void setIsFeedback(String isFeedback) {
		this.isFeedback = isFeedback;
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
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getFeedbackInfo() {
		return feedbackInfo;
	}
	public void setFeedbackInfo(String feedbackInfo) {
		this.feedbackInfo = feedbackInfo;
	}
	public String getPlanDesc() {
		return planDesc;
	}
	public void setPlanDesc(String planDesc) {
		this.planDesc = planDesc;
	}
	@Override
	public String toString() {
		return "Plan [planId=" + planId + ", planName=" + planName
				+ ", status=" + status + ", isFeedback=" + isFeedback
				+ ", beginDate=" + beginDate + ", endDate=" + endDate
				+ ", taskId=" + taskId + ", feedbackInfo=" + feedbackInfo
				+ ", planDesc=" + planDesc + "]";
	}
	
	
}
