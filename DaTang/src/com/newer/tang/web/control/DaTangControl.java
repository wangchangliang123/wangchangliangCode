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
	//��ѯȫ����ɫ�����¼����
	@RequestMapping("emp_input")
	public String queryRole(Model model){
		System.out.println("�����¼");
		List<Role> allRole=roleDao.queryRole();
		model.addAttribute("roles", allRole);
		return "login.jsp";
	}
	
	//��֤��¼�ķ���
	@RequestMapping("login.do")
	public String login(@ModelAttribute Employee employee,HttpSession session){
		System.out.println("�û�������˺ţ�"+employee.getEmployeeName());
		System.out.println("�û���������룺"+employee.getPassword());
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("username",employee.getEmployeeName());
		map.put("password",employee.getPassword());
		Employee emp=employeedao.queryByNameAndPassword(map);
		if(emp!=null){
			session.setAttribute("emp",emp);
		System.out.println("��ѯ���ĵ�¼�û���"+emp);
			if(emp.getRole().getRoleId()==2){
				return "admin/welcome.jsp";
			}else if(emp.getRole().getRoleId()==3){
				return "manager/welcome.jsp";
			}else if(emp.getRole().getRoleId()==4){
				return "person/welcome.jsp";
			}else{
				session.setAttribute("msg", "�û������������");
				return "error.jsp";
			}
		}else{
			session.setAttribute("msg", "�û������������");
			return "error.jsp";
		}
	}
	
	
	//�鿴����
	@RequestMapping("AllTask.do")
	public String queryTask(Model model){
		System.out.println("��ѯ��������");
		List<Task> all=taskdao.queryAllTask();
		System.out.println("��������ѯ������������Ϣ��"+all.toString());
		model.addAttribute("tasks", all);
		return "manager/taskview.jsp";
	}
	
	@RequestMapping("taskparticular.do")
	public String taskById(@RequestParam("radiobutton") Integer id,Model model,HttpSession session){
		System.out.println("�������������-��taskById");
		System.out.println(id);
		Task task=taskdao.queryByIdTask(id);
		model.addAttribute("task", task);
		//�ƻ���������
		session.setAttribute("taskName", task.getTaskName());
		return "manager/taskparticular.jsp";
	}
	
	@RequestMapping("planById.do")
	public String planById(@RequestParam("radiobutton") Integer id,Model model){
		System.out.println("���ݱ�Ų�ѯ��ϸ�ƻ�");
		Plan p=plandao.queryByIdPlan(id);
		System.out.println("���ݱ�Ų�ѯ�ƻ���"+p.toString());
		model.addAttribute("p", p);
		return "manager/program.jsp";
	}
	
	//�ƶ�����
		@RequestMapping("taskCreate.do")
		public String createTask(Model model){
			List<Employee> allEmp=employeedao.queryEmp();
			System.out.println("Ա����ȫ����Ϣ��"+allEmp.toString());
			model.addAttribute("emp", allEmp);
			return "manager/task.jsp";
		}
	
		@RequestMapping("taskCreate1.do")
		public String insertTask(@ModelAttribute Task t,
				@RequestParam("select") Integer implementorId,HttpSession sesion){
			Employee e=(Employee) sesion.getAttribute("emp");
			System.out.println("session�����ֵ��"+e.toString());
			t.setAssignerId(e.getEmployeeId());
			Employee emp=new Employee();
			emp.setEmployeeId(implementorId);
			t.setImplementorId(emp);
			System.out.println(t.toString());
			taskdao.insertTask(t);
			System.out.println("�ƶ���֤->createTask");
			return "AllTask.do";
		}
	
		//��������
		@RequestMapping("taskundone.do")
		public String taskundone(Model model,HttpServletRequest request){
			List<Task> allTask=taskdao.queryDSS();
			model.addAttribute("wsstask", allTask);
			return "manager/taskundone.jsp";
		}
		
		//����ɾ��δʵʩ����
		@RequestMapping("taskun.do")
		public String deleteTask(@RequestParam("radiobutton") String[] cheBoxValue){
			System.out.println("���ݸ�ѡ��ѡֵ����ɾ��");
			for (String value : cheBoxValue) {
				taskdao.deleteTask(Integer.parseInt(value));
			}
			return "taskundone.do";
		}
		
		//��������
		@RequestMapping("intendance.do")
		public String intendance(Model model,HttpServletRequest request){
			List<Task> allTask=taskdao.querySSZ();
			model.addAttribute("alltask", allTask);
			return "manager/intendance.jsp";
		}
		
		//������������
		@RequestMapping("prog.do")
		public String queryProg(@RequestParam("radiobutton") Integer id,Model model){
			Task task=taskdao.queryByIdgengzonTask(id);
			System.out.println("��������ѯ���ĸ�������"+task.toString());
			model.addAttribute("task", task);
			return "manager/programinten.jsp";
		}
		
		
		@RequestMapping("update.do")
		public String updateTask(@RequestParam("id") Integer id,@RequestParam("select") String status) throws UnsupportedEncodingException{
			//�����������޸�״̬
			String s="";
			if(status.equals("1")){
				s="ʵʩ��";
			}else if(status.equals("2")){
				s="�����";
			}
			System.out.println("����������"+id+"�޸�״̬"+s);
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("status",s);
			map.put("taskid", id);
			taskdao.updateTask(map);
			return "intendance.do";
		}
		
		//�鿴��Ա
		@RequestMapping("checkper.do")
		public String checkper(Model model,HttpServletRequest request){
			List<Employee> alls=employeedao.queryEmp();
			model.addAttribute("employees", alls);
			return "manager/checkper.jsp";
		}
		
		@RequestMapping("personinfo.do")
		public String queryById(@RequestParam("radiobutton") Integer id,Model model){
			System.out.println("���ݱ�Ų�ѯԱ����Ϣ");
			System.out.println("��ѯԱ���ı�ţ�"+id);
			//���ݱ�Ų�ѯԱ��������Ϣ
			Employee emp=employeedao.queryByIdEmp(id);
			model.addAttribute("emp", emp);
			return "manager/personinfo.jsp";
		}
		
		@RequestMapping("adjust.do")
		public String updateAdjust(@RequestParam("id") Integer id,Model model){
			System.out.println("���ݱ�ŵ���������Ϣ��"+id);
			Task t=taskdao.queryByIdgengzonTask(id);
			List<Employee> alls=employeedao.queryEmp();
					
			model.addAttribute("employees", alls);
			
			model.addAttribute("updateTask", t);
			return "manager/adjust.jsp";
		}
		
		@RequestMapping("update1.do")
		public String update(@ModelAttribute Task t,@RequestParam("select") Integer empId,@RequestParam("id") Integer taskId){
			System.out.println("�޸�");
			t.setTaskId(taskId);
			Employee emp=new Employee();
			emp.setEmployeeId(empId);
			t.setImplementorId(emp);
			System.out.println("��Ϣ��"+t.toString());
			int count=taskdao.updateTaskAll(t);
			if(count>0){
				System.out.println("�޸ĳɹ�");
			}else{
				System.out.println("�޸�ʧ��");
			}
			return "taskundone.do";
		}
		
	//�˳�
		@RequestMapping("invalidate.do")
		public String invalidate(HttpSession session){
			session.invalidate();
			return "emp_input";
		}
		
		//-------------Ա��
		//�ƻ�����
		@RequestMapping("emptask.do")
		public String empTask(HttpServletRequest request,Model model,HttpSession session){
			Employee e=(Employee) session.getAttribute("emp");
			List<Task> all=taskdao.queryByIdallTask(e.getEmployeeId());
			List<Plan> plan =null;
			for (Task task : all) {
				System.out.println("��ţ�"+task.getTaskId());
				plan=plandao.queryPlanById(task.getTaskId());
				System.out.println("������"+plan.size());
				task.setPlan(plan);
			}
			model.addAttribute("count", plan.size());
			model.addAttribute("taskAll",all);
			return "person/task.jsp";
		}
		
		//�鿴�ƻ�����
		@RequestMapping("taskview1.do")
		public String taskBy(@RequestParam("radiobutton") Integer id,Model model,HttpSession session){
			Task task=taskdao.queryByIdTask(id);
			System.out.println("�鿴�ƻ����飺"+task.toString());
			session.setAttribute("taskid", task.getTaskId());
			model.addAttribute("task", task);
			return "person/taskview.jsp";
		}
		
		//����ɾ���ƻ�
		@RequestMapping("deletenewpro.do")
		public String deletePlan(@RequestParam("chebox") String [] chebox){
			System.out.println("���ݱ������ɾ���ƻ�");
			for (String pid : chebox) {
				System.out.println("ɾ���ı���У�"+pid);
				plandao.deletePlan(Integer.parseInt(pid));
			}
			return "emptask.do";
		}
		
		//�����ƻ�
		@RequestMapping("insertPlan.do")
		public String insertPlan(@ModelAttribute Plan p,HttpSession session){
			System.out.println("�����ƻ�");
			System.out.println(p.toString());
			Integer taskId=(Integer) session.getAttribute("taskid");
			p.setTaskId(taskId);
			int count=plandao.insertPlan(p);
			if(count>0){
				System.out.println("�����ɹ�");
			}
			return "emptask.do";
		}
		
		//��ѯ�ƻ�
		@RequestMapping("queryPlan.do")
		public String queryPlan(Model model,HttpSession session){
			Employee e=(Employee) session.getAttribute("emp");
			System.out.println("�Ự��Χȡ����¼Ա����ţ�"+e.getEmployeeId());
			List<Task> mt=taskdao.queryByIdallTask(e.getEmployeeId());
			model.addAttribute("mt", mt);
			return "person/checkpro.jsp";
		}
		
		@RequestMapping("advancedquery.do")
		public String advancedquery(@ModelAttribute TaskPlanDTO dto,@RequestParam("select") int id,HttpServletRequest request,Model model,HttpSession session){
			dto.setTaskId(id);
			
			System.out.println("�߼���ѯ������"+dto.toString());
			List<Plan> allPlan=plandao.advancedPlan(dto);
			System.out.println("�߼���ѯ��ļƻ���"+allPlan.toString());
			model.addAttribute("dto",dto);
			model.addAttribute("plans",allPlan);
			for (Plan plan : allPlan) {
				System.out.println("��ţ�"+plan.getTaskId());
				Task t=taskdao.queryByIdTask(plan.getTaskId());
				System.out.println("��������"+t.getTaskName());
				model.addAttribute("taskName", t.getTaskName());
			}

			
			Employee e=(Employee) session.getAttribute("emp");
			List<Task> mt=taskdao.queryByIdallTask(e.getEmployeeId());
			
			model.addAttribute("mt", mt);
			
			return "person/checkpro.jsp";
		}
		
		//�˳�ϵͳ
		@RequestMapping("Planinvalidate.do")
		public String Planinvalidate(HttpSession session){
			session.invalidate();
			return "emp_input";
		}
		
		
		//------------����Ա-------
		//�û������ѯ
		@RequestMapping("userSelect.do")
		public String userSelect(Model model,HttpServletRequest request){
			List<Employee> employee=employeedao.queryAllEmployeeRole();
			model.addAttribute("userSelect", employee);
			return "admin/useradmin.jsp";
		}
		
		//�û�����
		@RequestMapping("userAdd.do")
		public String userAdd(Model model){		
			Employee emp=new Employee();
			emp.setSex("��");
			
			List<String> sex = new ArrayList<String>();
			sex.add("��");
			sex.add("Ů");
			model.addAttribute("sexs", sex);
			
			
			List<String> major = new ArrayList<String>();
			major.add("�г�Ӫ��");
			major.add("���");
			major.add("�����");
			major.add("���ڹ���");
			model.addAttribute("major", major);
			
			List<String> edc = new ArrayList<String>();
			edc.add("Сѧ");
			edc.add("����");
			edc.add("����");
			edc.add("��ר");
			edc.add("��ѧ");
			edc.add("˶ʿ");
			edc.add("��ʿ");
			edc.add("��ʿ��");
			model.addAttribute("edcucation", edc);
			
			model.addAttribute("emp", emp);
			return "forward:/admin/personadd.jsp";
		}
		
		//���һ����Ա��
		@RequestMapping("userAdds.do")
		public String usersAdd(@ModelAttribute("emp") Employee emp,Model model){
			System.out.println(emp.toString());
			
			int count=employeedao.insertEmployee(emp);
			System.out.println("����Ա��������"+count);
			return "userSelect.do";
		}
		
		//Ա�������ѯ
		@RequestMapping("select.do")
		public String selectAll(Model model,HttpServletRequest request){
			List<Employee> employee=employeedao.queryAllEmployeeRole();
			System.out.println("Ա����"+employee);
			model.addAttribute("selectAll", employee);
			return "admin/empadmin.jsp";
		}
		
		//ɾ���û�
		@RequestMapping("delete.do")
		public String deleteUser(@ModelAttribute("deleteUser") Employee emp,@RequestParam("radiobutton") Integer id, Model model){			
			emp.setEmployeeId(id);
			System.out.println(id);
			int count=employeedao.deleteTask(emp.getEmployeeId());
			int count1=employeedao.deleteEmployee(emp.getEmployeeId());
			System.out.println("ִ������"+count);
			System.out.println("ִ������1"+count1);
			return "select.do";
		}
		
		
		//������Ա��ѯ
		@RequestMapping("fuser.do")
		public String fuser(Model model,HttpServletRequest request){
			List<Employee> employee=employeedao.queryAllEmployeeRole();
			model.addAttribute("selectAll", employee);
			return "admin/empdistribute.jsp";
		}
		
		
		//�޸��û�
				@RequestMapping("updateUser.do")
				public String updateUser(@RequestParam("radiobutton") Integer id,Employee emp,Model model){
					emp.setEmployeeId(id);
					System.out.println("���ݵ�id��"+id);
					Employee all=employeedao.queryByIdEmp(id);
					System.out.println(all);
					
					List<String> sex = new ArrayList<String>();
					sex.add("��");
					sex.add("Ů");
					model.addAttribute("sexs", sex);
					
					
					List<String> major = new ArrayList<String>();
					major.add("�г�Ӫ��");
					major.add("���");
					major.add("�����");
					major.add("���ڹ���");
					model.addAttribute("major", major);
					
					List<String> edc = new ArrayList<String>();
					edc.add("Сѧ");
					edc.add("����");
					edc.add("����");
					edc.add("��ר");
					edc.add("��ѧ");
					edc.add("˶ʿ");
					edc.add("��ʿ");
					edc.add("��ʿ��");
					model.addAttribute("edcucation", edc);
					
					model.addAttribute("update", all);
					return "admin/persondesc.jsp";
				}
				
				//�޸�Ա��
				@RequestMapping("updateUsers.do")
				public String update(@ModelAttribute() Employee emp, Model model){
					int count=employeedao.updateByIdEmployee(emp);
					System.out.println("�޸ĺ��������"+count);
					return "fuser.do";
				}
				
				//�˳�ϵͳ
				@RequestMapping("loging.do")
				public String login(HttpSession session){
					session.removeAttribute("emp");
					return "/emp_input";
				}
		
}
