package com.newer.tang.data.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.newer.tang.data.dao.IRoleDAO;
import com.newer.tang.data.dao.ITaskDAO;
import com.newer.tang.data.entity.Role;
import com.newer.tang.data.entity.Task;
@Repository("taskDAO")
public class TaskDAOImpl extends SqlSessionDaoSupport implements ITaskDAO {

	@Resource(name="sqlSessionFactory")
	SqlSessionFactory sqlSessionFactory;
	
	@PostConstruct
    private void initialize() {
        setSqlSessionFactory(sqlSessionFactory);
    }
	
	@Override
	public List<Task> queryAllTask() {
		List<Task> tasks=null;
		try {
			SqlSession session=super.getSqlSession();
			ITaskDAO dao=session.getMapper(ITaskDAO.class);
			tasks=dao.queryAllTask();
			System.out.println("实现类查询到的全部角色："+tasks.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks;
	}
	


	@Override
	public Task queryByIdTask(int taskid) {
		Task t=null;
		try {
			SqlSession session=super.getSqlSession();
			ITaskDAO dao=session.getMapper(ITaskDAO.class);
			System.out.println("编号："+taskid);
			t=dao.queryByIdTask(taskid);
			System.out.println("实现类根据编号查询到的任务："+t.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public int insertTask(Task t) {
		int count=0;
		try {
			SqlSession session=super.getSqlSession();
			ITaskDAO dao=session.getMapper(ITaskDAO.class);
			count=dao.insertTask(t);
			System.out.println("实现类新增任务总数："+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Task> queryDSS() {
		List<Task> tasks=null;
		try {
			SqlSession session=super.getSqlSession();
			ITaskDAO dao=session.getMapper(ITaskDAO.class);
			tasks=dao.queryDSS();
			System.out.println("实现类查询到的待实施任务："+tasks.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks;
	}

	@Override
	public int deleteTask(int id) {
		int count=0;
		try {
			SqlSession session=super.getSqlSession();
			ITaskDAO dao=session.getMapper(ITaskDAO.class);
			count=dao.deleteTask(id);
			System.out.println("实现类删除未实施任务总数："+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Task> querySSZ() {
		List<Task> tasks=null;
		try {
			SqlSession session=super.getSqlSession();
			ITaskDAO dao=session.getMapper(ITaskDAO.class);
			tasks=dao.querySSZ();
			System.out.println("实现类查询到的实施中任务："+tasks.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks;
	}

	@Override
	public Task queryByIdgengzonTask(int taskid) {
		Task t=null;
		try {
			SqlSession session=super.getSqlSession();
			ITaskDAO dao=session.getMapper(ITaskDAO.class);
			t=dao.queryByIdgengzonTask(taskid);
			System.out.println("实现类根据编号查询到的任务："+t.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public int updateTask(Map<String, Object> map) {
		int count=0;
		try {
			SqlSession session=super.getSqlSession();
			ITaskDAO dao=session.getMapper(ITaskDAO.class);
			count=dao.updateTask(map);
			System.out.println("实现类根据编号修改任务状态："+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateTaskAll(Task t) {
		int count=0;
		try {
			SqlSession session=super.getSqlSession();
			ITaskDAO dao=session.getMapper(ITaskDAO.class);
			count=dao.updateTaskAll(t);
			System.out.println("实现类x修改任务信息总数："+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Task> queryByIdallTask(int employeeid) {
		List<Task> tasks=null;
		try {
			SqlSession session=super.getSqlSession();
			ITaskDAO dao=session.getMapper(ITaskDAO.class);
			tasks=dao.queryByIdallTask(employeeid);
			System.out.println("实现类根据员工编号查询到的任务："+tasks.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks;
	}


	
	
}
