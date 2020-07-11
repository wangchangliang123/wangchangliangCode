package com.newer.tang.data.dao;

import java.util.List;
import java.util.Map;

import com.newer.tang.data.entity.Employee;

public interface IEmployeeDAO {
	//��֤��¼
	public Employee queryByNameAndPassword(Map<String,Object> map);
	//��ѯԱ��
	public List<Employee> queryEmp();
	//���ݱ�Ų�ѯԱ����Ϣ
	public Employee queryByIdEmp(int empid);
	//����һ��Ա��
	public int insertEmployee(Employee emp);
	//��ѯȫ��Ա������ɫ
	public List<Employee> queryAllEmployeeRole();
	//ɾ��Ա��
	public int deleteTask(int taskid);
	public int deleteEmployee(int employeeid);
	//���ݱ���޸�Ա����Ϣ
	public int updateByIdEmployee(Employee emp);
}
