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
		System.out.println("��¼");
		Employee emp=null;
		try {
			SqlSession session=super.getSqlSession();
			System.out.println("���Ӷ���"+session);
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			emp=dao.queryByNameAndPassword(map);
			System.out.println("ʵ�����¼�û��ǣ�"+emp);
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
			System.out.println("���Ӷ���"+session);
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			allEmp=dao.queryEmp();
			System.out.println("ʵ�����ѯ����Ա����"+allEmp.toString());
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
			System.out.println("���Ӷ���"+session);
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			emp=dao.queryByIdEmp(empid);
			System.out.println("ʵ������ݱ�Ų�ѯԱ����Ϣ��"+emp);
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
			System.out.println("���Ӷ���"+session);
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			count=dao.insertEmployee(emp);
			System.out.println("ʵ��������һ��Ա��������"+count);
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
			System.out.println("���Ӷ���"+session);
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			allEmp=dao.queryAllEmployeeRole();
			System.out.println("ʵ�����ѯ����Ա������ɫ��"+allEmp.toString());
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
			System.out.println("���Ӷ���"+session);
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			count=dao.deleteTask(taskid);
			System.out.println("ʵ����ɾ������������"+count);
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
			System.out.println("���Ӷ���"+session);
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			count=dao.deleteEmployee(employeeid);
			System.out.println("ʵ����ɾ��һ��Ա��������"+count);
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
			System.out.println("���Ӷ���"+session);
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			count=dao.updateByIdEmployee(emp);
			System.out.println("ʵ�����޸�һ��Ա��������"+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
