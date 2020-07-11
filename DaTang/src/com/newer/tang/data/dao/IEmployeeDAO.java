package com.newer.tang.data.dao;

import java.util.List;
import java.util.Map;

import com.newer.tang.data.entity.Employee;

public interface IEmployeeDAO {
	//验证登录
	public Employee queryByNameAndPassword(Map<String,Object> map);
	//查询员工
	public List<Employee> queryEmp();
	//根据编号查询员工信息
	public Employee queryByIdEmp(int empid);
	//新增一名员工
	public int insertEmployee(Employee emp);
	//查询全部员工及角色
	public List<Employee> queryAllEmployeeRole();
	//删除员工
	public int deleteTask(int taskid);
	public int deleteEmployee(int employeeid);
	//根据编号修改员工信息
	public int updateByIdEmployee(Employee emp);
}
