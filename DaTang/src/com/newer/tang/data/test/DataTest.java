package com.newer.tang.data.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.newer.tang.data.dao.IEmployeeDAO;
import com.newer.tang.data.dao.IPlanDAO;
import com.newer.tang.data.dao.IRoleDAO;
import com.newer.tang.data.dao.ITaskDAO;
import com.newer.tang.data.dao.impl.EmployeeDAOImpl;
import com.newer.tang.data.entity.Employee;
import com.newer.tang.data.entity.Plan;
import com.newer.tang.data.entity.Role;
import com.newer.tang.data.entity.Task;
import com.newer.tang.web.util.TaskPlanDTO;

@RunWith(SpringJUnit4ClassRunner.class)//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DataTest {
	
	@Resource(name="roleDAO")
	IRoleDAO roledao;
	
	@Resource(name="employeeDAO")
	IEmployeeDAO employeedao;
	
	@Resource(name="taskDAO")
	ITaskDAO taskdao;
	
	@Resource(name="planDAO")
	IPlanDAO plandao;
	
	@Test
	public void TangTest(){
		TaskPlanDTO dto=new TaskPlanDTO();
		dto.setPlanName("计划");
		dto.setTaskId(5);
		List<Plan> all=plandao.advancedPlan(dto);
		System.out.println(all.toString());
		
		/*List<Task> all=taskdao.queryByIdallTask(7);
		System.out.println(all.toString());
		for (Task task : all) {
			
			System.out.println(task.getPlan().size());
			
		}*/
		
		/*List<Task> allTask=taskdao.queryDSS();
		System.out.println(allTask.toString());*/
		
		/*List<Employee> allEmp=employeedao.queryEmp();
		System.out.println(allEmp.toString());*/
		
		/*Plan p=plandao.queryByIdPlan(1);
		System.out.println(p.toString());*/
		
		/*Task t=taskdao.queryByIdTask(1);
		System.out.println(t.toString());*/
		/*List<Task> all=taskdao.queryAllTask();
		System.out.println(all.toString());*/
		
		/*Map<String, Object> map=new HashMap<String, Object>();
		map.put("username","lisi");
		map.put("password","123456");
		Employee emp=employeedao.queryByNameAndPassword(map);
		System.out.println(emp.toString());*/
		
		//-------role
		/*List<Role> all=roledao.queryRole();
		System.out.println(all.toString());*/
		
		
		
	}
}
