package com.newer.tang.data.dao;

import java.util.List;
import java.util.Map;

import com.newer.tang.data.entity.Employee;
import com.newer.tang.data.entity.Role;

public interface IRoleDAO {
	//��ѯȫ����ɫ
	public List<Role> queryRole();
	
	//��֤��¼
		public Employee queryByNameAndPassword(Map<String,Object> map);
	
}
