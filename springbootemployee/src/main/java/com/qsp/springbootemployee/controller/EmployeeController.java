package com.qsp.springbootemployee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springbootemployee.dto.Employee;
import com.qsp.springbootemployee.service.EmployeeService;
import com.qsp.springbootemployee.util.ResponseStructure;

@RestController
public class EmployeeController 
{
	@Autowired
	private EmployeeService service;
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@Valid @RequestBody Employee employee) 
	{
		return service.saveEmployee(employee);
	}
	@GetMapping("/fetch")
	public ResponseEntity<ResponseStructure<Employee>> findEmployee(@RequestParam int id) 
	{
		return service.findEmployee(id);
	}
	@GetMapping("/fetchAll")
	public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmployees() 
	{
		return service.getAllEmployee();
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@PathVariable int id) 
	{
		return service.deleteEmployee(id);
	}
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestParam int id,@Valid @RequestBody Employee employee)
	{
		return service.updateEmployee(id, employee);
	}
	@PatchMapping("/updateEmail/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updateEmail(@PathVariable int id,@Valid @RequestParam String email) 
	{
		return service.updateEmail(id,email);
	}
	
	@PatchMapping("/updatePhone/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updatePhone(@PathVariable int id,@Valid @RequestParam long phone) 
	{
		return service.updatePhone(id,phone);
	}
	
	@PatchMapping("/updateAddress/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updateAddress(@PathVariable int id,@Valid @RequestParam String address) 
	{
		return service.updateAddress(id,address);
	}
	
	@PatchMapping("/updateSalary/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updateSalary(@PathVariable int id,@Valid @RequestParam double salary) 
	{
		return service.updateSalary(id,salary);
	}
	@GetMapping("/findByEmail")
	public ResponseEntity<ResponseStructure<Employee>> findByEmail(@Valid @RequestParam String email)
	{
		return service.findByEmail(email);
	}
	@GetMapping("/findByPhone/{phone}")
	public ResponseEntity<ResponseStructure<Employee>> findByPhone(@Valid @PathVariable long phone)
	{
		return service.findByPhone(phone);
	}
	@GetMapping("/findEmpGreaterSal")
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmpGreaterSal(@Valid @RequestParam double salary)
	{
		return service.findEmpGreaterSal(salary);
	}
	
	@GetMapping("/findEmpLessSal")
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmpLessSal(@Valid @RequestParam double salary)
	{
		return service.findEmpLessSal(salary);
	}
}
