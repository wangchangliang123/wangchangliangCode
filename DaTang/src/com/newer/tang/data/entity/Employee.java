package com.newer.tang.data.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
	private int employeeId;//Ա�����
	private String employeeName;//�û�����
	private String password;//�û�����
	private String realName;//��ʵ����
	private String sex;//�Ա�
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;//��������
	private String duty;//ְλ��Ϣ
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date enrollDate;//��ְʱ��
	private String edcucation;//ѧ����Ϣ
	private String major;//רҵ��Ϣ
	private String experience;//��ҵ����
	private Role role;//��ɫ
	private int param;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getEdcucation() {
		return edcucation;
	}
	public void setEdcucation(String edcucation) {
		this.edcucation = edcucation;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public int getParam() {
		return param;
	}
	public void setParam(int param) {
		this.param = param;
	}
	public Employee(int employeeId, String employeeName, String password,
			String realName, String sex, Date birthday, String duty,
			Date enrollDate, String edcucation, String major,
			String experience, Role role, int param) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.password = password;
		this.realName = realName;
		this.sex = sex;
		this.birthday = birthday;
		this.duty = duty;
		this.enrollDate = enrollDate;
		this.edcucation = edcucation;
		this.major = major;
		this.experience = experience;
		this.role = role;
		this.param = param;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", password=" + password + ", realName="
				+ realName + ", sex=" + sex + ", birthday=" + birthday
				+ ", duty=" + duty + ", enrollDate=" + enrollDate
				+ ", edcucation=" + edcucation + ", major=" + major
				+ ", experience=" + experience + ", role=" + role + ", param="
				+ param + "]";
	}
	
	
}
