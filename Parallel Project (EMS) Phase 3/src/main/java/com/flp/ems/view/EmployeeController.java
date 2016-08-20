package com.flp.ems.view;


	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	import javax.validation.Valid;

	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.servlet.ModelAndView;

import com.flp.ems.domain.Employee;
import com.flp.ems.service.EmployeeService;

	@Controller
	public class EmployeeController {

		@Autowired
		private EmployeeService employeeService;
		private boolean flag=true;
		
		 Employee emp;
		 
		 @ModelAttribute("emp")
		 public Employee getEmployee()
		 {
			 return new Employee();
		 }
		@RequestMapping(value={"/employeeForm","/updateEmployee"})
		public String showEmployeeForm(ModelMap map,@RequestParam(value="id",required=false) String employeeid){
			//Map<String, Object> map=new  HashMap<>();
			int id;
			if(employeeid!=null)
				id=Integer.parseInt(employeeid);
			else
				id=-1;
			if(id!=-1){
			emp=employeeService.findById(id);
			System.out.println("Employee_id inside show EmployeeForm:"+emp.getEmpId());
			map.put("emp",emp);
		}
			map.put("deps", getAllDepartments());
			map.put("pros", getAllProjects());
			map.put("role", getAllRoles());
			/*map.put("employees", employeeService.getAllEmployees());*/
			if(flag)
				map.put("employees", employeeService.getAllEmployees());
			else{
				map.put("employees",employeeService.findById(id));
			}
			flag=true;
			return "employee";
		}
		
		
		@RequestMapping(value="/empSave",method=RequestMethod.POST)
		public String saveEmployee(@Valid @ModelAttribute("emp")Employee employee,
				BindingResult results,ModelMap map){
			//System.out.println(employee);
			//System.out.println("Employee_id in save :"+employee.getEmpId());
			map.put("deps", getAllDepartments());
			map.put("pros", getAllProjects());
			map.put("role", getAllRoles());
			map.put("employees", employeeService.getAllEmployees());
			
			if(results.hasErrors()){
				return "employee";
			}else{
				if(employee.getEmpId() == -1){
					employeeService.saveEmployee(employee);
					}
				else{
					employeeService.updateEmployee(employee);
					}
				return "redirect:/employeeForm";
			}
		}
		
		
		
		public List<String> getAllDepartments(){
			List<String> departs=new ArrayList<>();
			departs.add("ADM");
			departs.add("Cards");
			departs.add("InD");
			departs.add("Capital Market");
			departs.add("Support");
			departs.add("HR");
			departs.add("Training");
			return departs;
		}
		public List<String> getAllProjects(){
			List<String> projects=new ArrayList<>();
			projects.add("Morgan Stanley");
			projects.add("SAP Labs");
			projects.add("HP");
			projects.add("ORACLE");
			projects.add("PEGA");
			projects.add("Microsoft");
			projects.add("GUIDEWIRE");
			return projects;
		}
		public List<String> getAllRoles(){
			List<String> roles=new ArrayList<>();
			roles.add("Software Engineer");
			roles.add("Sr Software Engineer");
			roles.add("Software Analyst");
			roles.add("Consultant");
			roles.add("Associate Consultant");
			roles.add("Bench");
			return roles;
		}
		
		@RequestMapping("/deleteEmployee/{empId}")
		public String deleteEmployee(@PathVariable("empId") Integer employeeId){
			
			employeeService.deleteEmployee(employeeId);
			
			return "redirect:/employeeForm";
		}
		
		
		@RequestMapping(value ="/search",method=RequestMethod.POST)
		public String Search(@RequestParam(value="id",required=false) ModelMap map,String empid,Employee employee) {
			Employee e=new Employee();
			emp=e;
			int id;
			if(empid!=null)
			{
				id=Integer.parseInt(empid);
			}
			else
				id=-1;
			if(id!=-1){
				//emp=employeeService.findById(id);
				map.put("empl",employeeService.findById(id));
				map.put("employees", employeeService.getAllEmployees());
				map.put("deps", getAllDepartments());
				map.put("pros", getAllProjects());
				map.put("role", getAllRoles());
			
			}
			
			
			emp=employeeService.getEmployee(employee.getEmpId());
			e=emp!=null ?emp:new Employee(); 
			map.put("emp", e);
			map.put("employees",employeeService.getAllEmployees());
			
		   /* if(Id != 0){
		        Object searchResult = employeeService.findById(Id);
		        model.addAttribute("emp", searchResult);  
		    }*/
			 //ModelAndView mav = new ModelAndView("search");
			//flag=false;
		      return "employee";
		   // return "employeeForm";
		}
		
		
		
		
		
		
		
		
		
	}
