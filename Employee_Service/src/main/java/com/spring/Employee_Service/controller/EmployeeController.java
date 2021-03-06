package com.spring.Employee_Service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.splunk.Receiver;
import com.splunk.Service;
import com.spring.Employee_Service.EmployeeServiceApplication;
import com.spring.Employee_Service.model.Employee;
import com.spring.Employee_Service.model.EmployeeList;
import com.spring.Employee_Service.service.EmployeeService;

@RestController
public class EmployeeController {
	
	Service service = EmployeeServiceApplication.getService();
	Receiver receiver = service.getReceiver();

	//private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/listEmp")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/emp")
	public EmployeeList getEmployees(){
		/*
		 * receiver.log("deptemp", "In Employee Service-List All Employees");
		 * logger.info("List all Employees ");
		 */
		List<Employee> emp = employeeService.getAllEmployees();
		EmployeeList list = new EmployeeList();
		list.setEmployees(emp);
		return list;
		
	}
	
	
	@GetMapping("/listEmp/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployees(id);
	}
	
	@GetMapping("emp/{deptId}")
	public List<Employee> getEmployeeByDeptId(@PathVariable int deptId){
		
		return employeeService.getEmployeesByDept(deptId);
	}
	
	@GetMapping("empList/{deptId}")
	public EmployeeList getEmpByDeptId(@PathVariable int deptId) {
		//receiver.log("deptemp", "In Employee Service-List All Employees based on DeptId");
		List<Employee> emp = employeeService.getEmployeesByDept(deptId);
		EmployeeList list = new EmployeeList();
		list.setEmployees(emp);
		//logger.info("List all Employees based on Dept Id");
		return list;
	}
	
	@PostMapping("/addEmp")
	public Employee addEmployee(@RequestBody Employee employee) {
		/*
		 * receiver.log("deptemp", "In Employee Service-Add an Employee");
		 * logger.info("Add  Employee in DB");
		 */
		employeeService.insertEmployee(employee);
		return employee;
	}
	
	@PutMapping("/updateEmp/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
		/*
		 * receiver.log("deptemp", "In Employee Service-Update an Employee");
		 * logger.info("Update the particular Employee in DB");
		 */
		employeeService.updateEmployee(id, employee);
		return employee;
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public String deleteEmployee(@PathVariable int id) {
		//receiver.log("deptemp", "In Employee Service-Delete an Employee");
		employeeService.deleteEmployee(id);
		//logger.info("Delete the Employee in DB");
		return "Record Deleted";
		
	}

}
