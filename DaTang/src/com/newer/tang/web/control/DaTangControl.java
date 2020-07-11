package com.newer.tang.web.control;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.newer.tang.data.dao.IEmployeeDAO;
import com.newer.tang.data.dao.IPlanDAO;
import com.newer.tang.data.dao.IRoleDAO;
import com.newer.tang.data.dao.ITaskDAO;
import com.newer.tang.data.entity.Employee;
import com.newer.tang.data.entity.Plan;
import com.newer.tang.data.entity.Role;
import com.newer.tang.data.entity.Task;
import com.newer.tang.web.util.TaskPlanDTO;

@Controller
public class DaTangControl {
	
	@Resource(name="roleDAO")
	IRoleDAO roleDao;
	
	@Resource(name="employeeDAO")
	IEmployeeDAO employeedao;
	
	@Resource(name="taskDAO")
	ITaskDAO taskdao;
	
	@Resource(name="planDAO")
	IPlanDAO plandao;
	
	//---------Role-----
	//查询全部角色进入登录界面
	@RequestMapping("emp_input")
	public String queryRole(Model model){
		System.out.println("进入登录");
		List<Role> allRole=roleDao.queryRole();
		model.addAttribute("roles", allRole);
		return "login.jsp";
	}
	
	//验证登录的方法
	@RequestMapping("login.do")
	public String login(@ModelAttribute Employee employee,HttpSession session){
		System.out.println("用户输入的账号："+employee.getEmployeeName());
		System.out.println("用户输入的密码："+employee.getPassword());
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("username",employee.getEmployeeName());
		map.put("password",employee.getPassword());
		Employee emp=employeedao.queryByNameAndPassword(map);
		if(emp!=null){
			session.setAttribute("emp",emp);
		System.out.println("查询到的登录用户："+emp);
			if(emp.getRole().getRoleId()==2){
				return "admin/welcome.jsp";
			}else if(emp.getRole().getRoleId()==3){
				return "manager/welcome.jsp";
			}else if(emp.getRole().getRoleId()==4){
				return "person/welcome.jsp";
			}else{
				session.setAttribute("msg", "用户名或密码错误！");
				return "error.jsp";
			}
		}else{
			session.setAttribute("msg", "用户名或密码错误！");
			return "error.jsp";
		}
	}
	
	
	//查看任务
	@RequestMapping("AllTask.do")
	public String queryTask(Model model){
		System.out.println("查询所有任务");
		List<Task> all=taskdao.queryAllTask();
		System.out.println("控制器查询的所有任务信息："+all.toString());
		model.addAttribute("tasks", all);
		return "manager/taskview.jsp";
	}
	
	@RequestMapping("taskparticular.do")
	public String taskById(@RequestParam("radiobutton") Integer id,Model model,HttpSession session){
		System.out.println("任务详情控制器-》taskById");
		System.out.println(id);
		Task task=taskdao.queryByIdTask(id);
		model.addAttribute("task", task);
		//计划所属任务
		session.setAttribute("taskName", task.getTaskName());
		return "manager/taskparticular.jsp";
	}
	
	@RequestMapping("planById.do")
	public String planById(@RequestParam("radiobutton") Integer id,Model model){
		System.out.println("根据编号查询详细计划");
		Plan p=plandao.queryByIdPlan(id);
		System.out.println("根据编号查询计划："+p.toString());
		model.addAttribute("p", p);
		return "manager/program.jsp";
	}
	
	//制定任务
		@RequestMapping("taskCreate.do")
		public String createTask(Model model){
			List<Employee> allEmp=employeedao.queryEmp();
			System.out.println("员工的全部信息："+allEmp.toString());
			model.addAttribute("emp", allEmp);
			return "manager/task.jsp";
		}
	
		@RequestMapping("taskCreate1.do")
		public String insertTask(@ModelAttribute Task t,
				@RequestParam("select") Integer implementorId,HttpSession sesion){
			Employee e=(Employee) sesion.getAttribute("emp");
			System.out.println("session存入的值："+e.toString());
			t.setAssignerId(e.getEmployeeId());
			Employee emp=new Employee();
			emp.setEmployeeId(implementorId);
			t.setImplementorId(emp);
			System.out.println(t.toString());
			taskdao.insertTask(t);
			System.out.println("制定验证->createTask");
			return "AllTask.do";
		}
	
		//调整任务
		@RequestMapping("taskundone.do")
		public String taskundone(Model model,HttpServletRequest request){
			List<Task> allTask=taskdao.queryDSS();
			model.addAttribute("wsstask", allTask);
			return "manager/taskundone.jsp";
		}
		
		//批量删除未实施任务
		@RequestMapping("taskun.do")
		public String deleteTask(@RequestParam("radiobutton") String[] cheBoxValue){
			System.out.println("根据复选框勾选值进行删除");
			for (String value : cheBoxValue) {
				taskdao.deleteTask(Integer.parseInt(value));
			}
			return "taskundone.do";
		}
		
		//跟踪任务
		@RequestMapping("intendance.do")
		public String intendance(Model model,HttpServletRequest request){
			List<Task> allTask=taskdao.querySSZ();
			model.addAttribute("alltask", allTask);
			return "manager/intendance.jsp";
		}
		
		//跟踪任务详情
		@RequestMapping("prog.do")
		public String queryProg(@RequestParam("radiobutton") Integer id,Model model){
			Task task=taskdao.queryByIdgengzonTask(id);
			System.out.println("控制器查询到的跟踪任务："+task.toString());
			model.addAttribute("task", task);
			return "manager/programinten.jsp";
		}
		
		
		@RequestMapping("update.do")
		public String updateTask(@RequestParam("id") Integer id,@RequestParam("select") String status) throws UnsupportedEncodingException{
			//根据任务编号修改状态
			String s="";
			if(status.equals("1")){
				s="实施中";
			}else if(status.equals("2")){
				s="已完成";
			}
			System.out.println("根据任务编号"+id+"修改状态"+s);
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("status",s);
			map.put("taskid", id);
			taskdao.updateTask(map);
			return "intendance.do";
		}
		
		//查看人员
		@RequestMapping("checkper.do")
		public String checkper(Model model,HttpServletRequest request){
			List<Employee> alls=employeedao.queryEmp();
			model.addAttribute("employees", alls);
			return "manager/checkper.jsp";
		}
		
		@RequestMapping("personinfo.do")
		public String queryById(@RequestParam("radiobutton") Integer id,Model model){
			System.out.println("根据编号查询员工信息");
			System.out.println("查询员工的编号："+id);
			//根据编号查询员工详情信息
			Employee emp=employeedao.queryByIdEmp(id);
			model.addAttribute("emp", emp);
			return "manager/personinfo.jsp";
		}
		
		@RequestMapping("adjust.do")
		public String updateAdjust(@RequestParam("id") Integer id,Model model){
			System.out.println("根据编号调整任务信息："+id);
			Task t=taskdao.queryByIdgengzonTask(id);
			List<Employee> alls=employeedao.queryEmp();
					
			model.addAttribute("employees", alls);
			
			model.addAttribute("updateTask", t);
			return "manager/adjust.jsp";
		}
		
		@RequestMapping("update1.do")
		public String update(@ModelAttribute Task t,@RequestParam("select") Integer empId,@RequestParam("id") Integer taskId){
			System.out.println("修改");
			t.setTaskId(taskId);
			Employee emp=new Employee();
			emp.setEmployeeId(empId);
			t.setImplementorId(emp);
			System.out.println("信息："+t.toString());
			int count=taskdao.updateTaskAll(t);
			if(count>0){
				System.out.println("修改成功");
			}else{
				System.out.println("修改失败");
			}
			return "taskundone.do";
		}
		
	//退出
		@RequestMapping("invalidate.do")
		public String invalidate(HttpSession session){
			session.invalidate();
			return "emp_input";
		}
		
		//-------------员工
		//计划管理
		@RequestMapping("emptask.do")
		public String empTask(HttpServletRequest request,Model model,HttpSession session){
			Employee e=(Employee) session.getAttribute("emp");
			List<Task> all=taskdao.queryByIdallTask(e.getEmployeeId());
			List<Plan> plan =null;
			for (Task task : all) {
				System.out.println("编号："+task.getTaskId());
				plan=plandao.queryPlanById(task.getTaskId());
				System.out.println("总数："+plan.size());
				task.setPlan(plan);
			}
			model.addAttribute("count", plan.size());
			model.addAttribute("taskAll",all);
			return "person/task.jsp";
		}
		
		//查看计划详情
		@RequestMapping("taskview1.do")
		public String taskBy(@RequestParam("radiobutton") Integer id,Model model,HttpSession session){
			Task task=taskdao.queryByIdTask(id);
			System.out.println("查看计划详情："+task.toString());
			session.setAttribute("taskid", task.getTaskId());
			model.addAttribute("task", task);
			return "person/taskview.jsp";
		}
		
		//批量删除计划
		@RequestMapping("deletenewpro.do")
		public String deletePlan(@RequestParam("chebox") String [] chebox){
			System.out.println("根据编号批量删除计划");
			for (String pid : chebox) {
				System.out.println("删除的编号有："+pid);
				plandao.deletePlan(Integer.parseInt(pid));
			}
			return "emptask.do";
		}
		
		//新增计划
		@RequestMapping("insertPlan.do")
		public String insertPlan(@ModelAttribute Plan p,HttpSession session){
			System.out.println("新增计划");
			System.out.println(p.toString());
			Integer taskId=(Integer) session.getAttribute("taskid");
			p.setTaskId(taskId);
			int count=plandao.insertPlan(p);
			if(count>0){
				System.out.println("新增成功");
			}
			return "emptask.do";
		}
		
		//查询计划
		@RequestMapping("queryPlan.do")
		public String queryPlan(Model model,HttpSession session){
			Employee e=(Employee) session.getAttribute("emp");
			System.out.println("会话范围取出登录员工编号："+e.getEmployeeId());
			List<Task> mt=taskdao.queryByIdallTask(e.getEmployeeId());
			model.addAttribute("mt", mt);
			return "person/checkpro.jsp";
		}
		
		@RequestMapping("advancedquery.do")
		public String advancedquery(@ModelAttribute TaskPlanDTO dto,@RequestParam("select") int id,HttpServletRequest request,Model model,HttpSession session){
			dto.setTaskId(id);
			
			System.out.println("高级查询参数："+dto.toString());
			List<Plan> allPlan=plandao.advancedPlan(dto);
			System.out.println("高级查询后的计划："+allPlan.toString());
			model.addAttribute("dto",dto);
			model.addAttribute("plans",allPlan);
			for (Plan plan : allPlan) {
				System.out.println("编号："+plan.getTaskId());
				Task t=taskdao.queryByIdTask(plan.getTaskId());
				System.out.println("任务名："+t.getTaskName());
				model.addAttribute("taskName", t.getTaskName());
			}

			
			Employee e=(Employee) session.getAttribute("emp");
			List<Task> mt=taskdao.queryByIdallTask(e.getEmployeeId());
			
			model.addAttribute("mt", mt);
			
			return "person/checkpro.jsp";
		}
		
		//退出系统
		@RequestMapping("Planinvalidate.do")
		public String Planinvalidate(HttpSession session){
			session.invalidate();
			return "emp_input";
		}
		
		
		//------------管理员-------
		//用户管理查询
		@RequestMapping("userSelect.do")
		public String userSelect(Model model,HttpServletRequest request){
			List<Employee> employee=employeedao.queryAllEmployeeRole();
			model.addAttribute("userSelect", employee);
			return "admin/useradmin.jsp";
		}
		
		//用户新增
		@RequestMapping("userAdd.do")
		public String userAdd(Model model){		
			Employee emp=new Employee();
			emp.setSex("男");
			
			List<String> sex = new ArrayList<String>();
			sex.add("男");
			sex.add("女");
			model.addAttribute("sexs", sex);
			
			
			List<String> major = new ArrayList<String>();
			major.add("市场营销");
			major.add("会计");
			major.add("计算机");
			major.add("金融管理");
			model.addAttribute("major", major);
			
			List<String> edc = new ArrayList<String>();
			edc.add("小学");
			edc.add("初中");
			edc.add("高中");
			edc.add("大专");
			edc.add("大学");
			edc.add("硕士");
			edc.add("博士");
			edc.add("博士后");
			model.addAttribute("edcucation", edc);
			
			model.addAttribute("emp", emp);
			return "forward:/admin/personadd.jsp";
		}
		
		//添加一名新员工
		@RequestMapping("userAdds.do")
		public String usersAdd(@ModelAttribute("emp") Employee emp,Model model){
			System.out.println(emp.toString());
			
			int count=employeedao.insertEmployee(emp);
			System.out.println("新增员工总数："+count);
			return "userSelect.do";
		}
		
		//员工管理查询
		@RequestMapping("select.do")
		public String selectAll(Model model,HttpServletRequest request){
			List<Employee> employee=employeedao.queryAllEmployeeRole();
			System.out.println("员工："+employee);
			model.addAttribute("selectAll", employee);
			return "admin/empadmin.jsp";
		}
		
		//删除用户
		@RequestMapping("delete.do")
		public String deleteUser(@ModelAttribute("deleteUser") Employee emp,@RequestParam("radiobutton") Integer id, Model model){			
			emp.setEmployeeId(id);
			System.out.println(id);
			int count=employeedao.deleteTask(emp.getEmployeeId());
			int count1=employeedao.deleteEmployee(emp.getEmployeeId());
			System.out.println("执行条数"+count);
			System.out.println("执行条数1"+count1);
			return "select.do";
		}
		
		
		//分配人员查询
		@RequestMapping("fuser.do")
		public String fuser(Model model,HttpServletRequest request){
			List<Employee> employee=employeedao.queryAllEmployeeRole();
			model.addAttribute("selectAll", employee);
			return "admin/empdistribute.jsp";
		}
		
		
		//修改用户
				@RequestMapping("updateUser.do")
				public String updateUser(@RequestParam("radiobutton") Integer id,Employee emp,Model model){
					emp.setEmployeeId(id);
					System.out.println("传递的id："+id);
					Employee all=employeedao.queryByIdEmp(id);
					System.out.println(all);
					
					List<String> sex = new ArrayList<String>();
					sex.add("男");
					sex.add("女");
					model.addAttribute("sexs", sex);
					
					
					List<String> major = new ArrayList<String>();
					major.add("市场营销");
					major.add("会计");
					major.add("计算机");
					major.add("金融管理");
					model.addAttribute("major", major);
					
					List<String> edc = new ArrayList<String>();
					edc.add("小学");
					edc.add("初中");
					edc.add("高中");
					edc.add("大专");
					edc.add("大学");
					edc.add("硕士");
					edc.add("博士");
					edc.add("博士后");
					model.addAttribute("edcucation", edc);
					
					model.addAttribute("update", all);
					return "admin/persondesc.jsp";
				}
				
				//修改员工
				@RequestMapping("updateUsers.do")
				public String update(@ModelAttribute() Employee emp, Model model){
					int count=employeedao.updateByIdEmployee(emp);
					System.out.println("修改后的总数："+count);
					return "fuser.do";
				}
				
				//退出系统
				@RequestMapping("loging.do")
				public String login(HttpSession session){
					session.removeAttribute("emp");
					return "/emp_input";
				}
		
}
