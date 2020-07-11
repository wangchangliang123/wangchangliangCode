package com.newer.tang.data.dao;

import java.util.List;
import java.util.Map;

import com.newer.tang.data.entity.Task;

public interface ITaskDAO {
	//查询全部任务
	public List<Task> queryAllTask();
	//按编号查询任务
	public Task queryByIdTask(int taskid);
	//新增一条新的任务
	public  int insertTask(Task t);
	//查询待实施的任务
	public List<Task> queryDSS();
	//根据编号删除任务
	public int deleteTask(int id);
	//查询待实施的任务
	public List<Task> querySSZ();
	//查询跟踪任务详情
	public Task queryByIdgengzonTask(int taskid);
	//根据编号修改状态
	public int updateTask(Map<String, Object> map);
	//根据编号修改任务信息
	public int updateTaskAll(Task t);
	//根据员工编号查询出所属任务
	public List<Task> queryByIdallTask(int employeeid);
	
}
