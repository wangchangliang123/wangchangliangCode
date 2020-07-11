package com.newer.tang.data.dao;

import java.util.List;

import com.newer.tang.data.entity.Plan;
import com.newer.tang.web.util.TaskPlanDTO;

public interface IPlanDAO {
	//根据编号查询计划
	public Plan queryByIdPlan(int taskid);
	//根据编号删除计划
	public int deletePlan(Integer pid);
	//新增一条计划
	public int insertPlan(Plan p);
	
	public List<Plan> queryPlanById(int taskid);
	
	public abstract List<Plan> advancedPlan(TaskPlanDTO dto);
}
