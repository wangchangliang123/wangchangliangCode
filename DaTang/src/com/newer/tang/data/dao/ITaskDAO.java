package com.newer.tang.data.dao;

import java.util.List;
import java.util.Map;

import com.newer.tang.data.entity.Task;

public interface ITaskDAO {
	//��ѯȫ������
	public List<Task> queryAllTask();
	//����Ų�ѯ����
	public Task queryByIdTask(int taskid);
	//����һ���µ�����
	public  int insertTask(Task t);
	//��ѯ��ʵʩ������
	public List<Task> queryDSS();
	//���ݱ��ɾ������
	public int deleteTask(int id);
	//��ѯ��ʵʩ������
	public List<Task> querySSZ();
	//��ѯ������������
	public Task queryByIdgengzonTask(int taskid);
	//���ݱ���޸�״̬
	public int updateTask(Map<String, Object> map);
	//���ݱ���޸�������Ϣ
	public int updateTaskAll(Task t);
	//����Ա����Ų�ѯ����������
	public List<Task> queryByIdallTask(int employeeid);
	
}
