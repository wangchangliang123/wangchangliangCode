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
@Repository("roleDAO")
public class RoleDAOImpl extends SqlSessionDaoSupport implements IRoleDAO {
	
	@Resource(name="sqlSessionFactory")
	SqlSessionFactory sqlSessionFactory;
	
	@PostConstruct
    private void initialize() {
        setSqlSessionFactory(sqlSessionFactory);
    }
	
	@Override
	public List<Role> queryRole() {
		List<Role> allRole=null;
		try {
			SqlSession session=super.getSqlSession();
			IRoleDAO dao=session.getMapper(IRoleDAO.class);
			allRole=dao.queryRole();
			System.out.println("ʵ�����ѯ����ȫ����ɫ��"+allRole.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allRole;
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
			System.out.println("ʵ�����¼�û��ǣ�"+emp.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
}
