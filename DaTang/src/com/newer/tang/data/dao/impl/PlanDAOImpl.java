package com.newer.tang.data.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.newer.tang.data.dao.IPlanDAO;
import com.newer.tang.data.entity.Plan;
import com.newer.tang.web.util.TaskPlanDTO;

@Repository("planDAO")
public class PlanDAOImpl extends SqlSessionDaoSupport implements IPlanDAO {
	
	@Resource(name="sqlSessionFactory")
	SqlSessionFactory sqlSessionFactory;
	
	@PostConstruct
    private void initialize() {
        setSqlSessionFactory(sqlSessionFactory);
    }
	
	@Override
	public Plan queryByIdPlan(int planid) {
		Plan p=null;
		try {
			SqlSession session=super.getSqlSession();
			IPlanDAO dao=session.getMapper(IPlanDAO.class);
			p=dao.queryByIdPlan(planid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	@Override
	public int deletePlan(Integer pid) {
		int count=0;
		try {
			SqlSession session=super.getSqlSession();
			System.out.println("连接对象："+session);
			IPlanDAO dao=session.getMapper(IPlanDAO.class);
			count=dao.deletePlan(pid);
			System.out.println("删除计划的总数："+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	
	@Override
	public int insertPlan(Plan p) {
		int count=0;
		try {
			SqlSession session=super.getSqlSession();
			System.out.println("连接对象："+session);
			IPlanDAO dao=session.getMapper(IPlanDAO.class);
			count=dao.insertPlan(p);
			System.out.println("实现类新增计划的总数："+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Plan> queryPlanById(int taskid) {
		List<Plan> plans=null;
		try {
			SqlSession session=super.getSqlSession();
			System.out.println("连接对象："+session);
			IPlanDAO dao=session.getMapper(IPlanDAO.class);
			plans=dao.queryPlanById(taskid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plans;
	}
	
	@Override
	public List<Plan> advancedPlan(TaskPlanDTO dto) {
		List<Plan> plans=null;
		try {
			SqlSession session=super.getSqlSession();
			System.out.println("连接对象："+session);
			IPlanDAO dao=session.getMapper(IPlanDAO.class);
			plans=dao.advancedPlan(dto);
			System.out.println("实现类高级查询到的计划信息："+plans.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plans;
	}

}
