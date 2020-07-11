package com.newer.tang.data.dao;

import java.util.List;
import java.util.Map;

import com.newer.tang.data.entity.Employee;
import com.newer.tang.data.entity.Role;

public interface IRoleDAO {
	//查询全部角色
	public List<Role> queryRole();
	
	//验证登录
		public Employee queryByNameAndPassword(Map<String,Object> map);
	
}
