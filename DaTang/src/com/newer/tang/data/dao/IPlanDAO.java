package com.newer.tang.data.dao;

import java.util.List;

import com.newer.tang.data.entity.Plan;
import com.newer.tang.web.util.TaskPlanDTO;

public interface IPlanDAO {
	//���ݱ�Ų�ѯ�ƻ�
	public Plan queryByIdPlan(int taskid);
	//���ݱ��ɾ���ƻ�
	public int deletePlan(Integer pid);
	//����һ���ƻ�
	public int insertPlan(Plan p);
	
	public List<Plan> queryPlanById(int taskid);
	
	public abstract List<Plan> advancedPlan(TaskPlanDTO dto);
}
