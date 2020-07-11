package com.newer.tang.data.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.newer.tang.data.dao.IEmployeeDAO;
import com.newer.tang.data.dao.IRoleDAO;
import com.newer.tang.data.entity.Employee;
import com.newer.tang.data.entity.Role;
@Repository("employeeDAO")
public class EmployeeDAOImpl extends SqlSessionDaoSupport implements IEmployeeDAO {
	
	@Resource(name="sqlSessionFactory")
	SqlSessionFactory sqlSessionFactory;
	
	@PostConstruct
    private void initialize() {
        setSqlSessionFactory(sqlSessionFactory);
    }
	
	
	@Override
	public Employee queryByNameAndPassword(Map<String, Object> map) {
		System.out.println("登录");
		Employee emp=null;
		try {
			SqlSession session=super.getSqlSession();
			System.out.println("连接对象："+session);
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			emp=dao.queryByNameAndPassword(map);
			System.out.println("实现类登录用户是："+emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}


	@Override
	public List<Employee> queryEmp() {
		List<Employee> allEmp=null;
		try {
			SqlSession session=super.getSqlSession();
			System.out.println("连接对象："+session);
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			allEmp=dao.queryEmp();
			System.out.println("实现类查询所有员工："+allEmp.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allEmp;
	}


	@Override
	public Employee queryByIdEmp(int empid) {
		Employee emp=null;
		try {
			SqlSession session=super.getSqlSession();
			System.out.println("连接对象："+session);
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			emp=dao.queryByIdEmp(empid);
			System.out.println("实现类根据编号查询员工信息："+emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}


	@Override
	public int insertEmployee(Employee emp) {
		int count=0;
		try {
			SqlSession session=super.getSqlSession();
			System.out.println("连接对象："+session);
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			count=dao.insertEmployee(emp);
			System.out.println("实现类新增一条员工总数："+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}


	@Override
	public List<Employee> queryAllEmployeeRole() {
		List<Employee> allEmp=null;
		try {
			SqlSession session=super.getSqlSession();
			System.out.println("连接对象："+session);
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			allEmp=dao.queryAllEmployeeRole();
			System.out.println("实现类查询所有员工及角色："+allEmp.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allEmp;
	}


	@Override
	public int deleteTask(int taskid) {
		int count=0;
		try {
			SqlSession session=super.getSqlSession();
			System.out.println("连接对象："+session);
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			count=dao.deleteTask(taskid);
			System.out.println("实现类删除任务总数："+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}


	@Override
	public int deleteEmployee(int employeeid) {
		int count=0;
		try {
			SqlSession session=super.getSqlSession();
			System.out.println("连接对象："+session);
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			count=dao.deleteEmployee(employeeid);
			System.out.println("实现类删除一条员工总数："+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}


	@Override
	public int updateByIdEmployee(Employee emp) {
		int count=0;
		try {
			SqlSession session=super.getSqlSession();
			System.out.println("连接对象："+session);
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			count=dao.updateByIdEmployee(emp);
			System.out.println("实现类修改一条员工总数："+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
