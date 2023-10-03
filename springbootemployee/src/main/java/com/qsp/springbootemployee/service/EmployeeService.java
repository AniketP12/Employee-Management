package com.qsp.springbootemployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.qsp.springbootemployee.dao.EmployeeDao;
import com.qsp.springbootemployee.dto.Employee;
import com.qsp.springbootemployee.exception.EmailNotPresent;
import com.qsp.springbootemployee.exception.IdNotFound;
import com.qsp.springbootemployee.exception.NoDataAvailable;
import com.qsp.springbootemployee.exception.NotInRange;
import com.qsp.springbootemployee.exception.PhoneNotPresent;
import com.qsp.springbootemployee.util.ResponseStructure;

@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeDao dao;
	
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee)
	{
		double salary=employee.getSalary();
		
		if(salary<10000)
		{
			employee.setGrade('A');
		}else if(salary>=10000 && salary<20000)
		{
			employee.setGrade('B');
		}else if(salary>=20000 && salary<40000)
		{
			employee.setGrade('C');
		}else {
			employee.setGrade('D');
		}
		ResponseStructure<Employee>structure=new ResponseStructure<Employee>();
		structure.setMessage("saved successfully!");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveEmployee(employee));
		
		return new ResponseEntity(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Employee>> findEmployee(int id)
	{
		 Employee employee=dao.findEmployee(id);
		 ResponseStructure<Employee>structure=new ResponseStructure<Employee>();
		 if(employee!=null)
		 {
			 structure.setMessage("Found Successfull!");
			 structure.setStatus(HttpStatus.FOUND.value());
			 structure.setData(employee);
			 
			 return new ResponseEntity(structure, HttpStatus.FOUND);
		 }else {
			 throw new IdNotFound("id not found");
		 }
		 
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmployee() 
	{
		List<Employee>list=dao.getAllEmployee();
		ResponseStructure<List<Employee>>structure=new ResponseStructure<List<Employee>>();
		if(list.isEmpty())
		{
			throw new NoDataAvailable("data not available");
		}else
		{
			structure.setMessage("Found Successfull!");
			 structure.setStatus(HttpStatus.FOUND.value());
			 structure.setData(list);
			 return new ResponseEntity(structure, HttpStatus.FOUND);
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(int id) 
	{
		Employee employee=dao.findEmployee(id);
		 ResponseStructure<Employee>structure=new ResponseStructure<Employee>();
		 if(employee!=null)
		 {
			 structure.setMessage("Delete Successfull!");
			 structure.setStatus(HttpStatus.OK.value());
			 structure.setData(dao.deleteEmployee(id));
			 
			 return new ResponseEntity(structure, HttpStatus.OK);
		 }else {
			 throw new IdNotFound("id not found");
		 }
		
		
	}
	
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(int id,Employee employee) 
	{
		Employee dbemployee=dao.findEmployee(id);
		ResponseStructure<Employee>structure=new ResponseStructure<Employee>();
		if(dbemployee!=null)
		{
			double salary=employee.getSalary();
			
			if(salary<10000)
			{
				employee.setGrade('A');
			}else if(salary>=10000 && salary<20000)
			{
				employee.setGrade('B');
			}else if(salary>=20000 && salary<40000)
			{
				employee.setGrade('C');
			}else {
				employee.setGrade('D');
			}
			
			structure.setMessage("updated successfully!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateEmployee(id, employee));
			return new ResponseEntity(structure, HttpStatus.OK);
		}else {
			throw new IdNotFound("id not found");
		}
		
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmail(int id, String email) 
	{
		Employee employee=dao.findEmployee(id);
		ResponseStructure<Employee>structure=new ResponseStructure<Employee>();
		if(employee!=null)
		{
			employee.setEmail(email);
			structure.setMessage("updated successfully!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateEmployee(id, employee));
			
			return new ResponseEntity(structure, HttpStatus.OK);
		}else {
			throw new IdNotFound("id not found");
		}
		
	}

	public ResponseEntity<ResponseStructure<Employee>> updatePhone(int id, long phone) 
	{
		Employee employee=dao.findEmployee(id);
		ResponseStructure<Employee>structure=new ResponseStructure<Employee>();
		if(employee!=null)
		{
			employee.setPhone(phone);
			structure.setMessage("updated successfully!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateEmployee(id, employee));
			
			return new ResponseEntity(structure, HttpStatus.OK);
		}else {
			throw new IdNotFound("id not found");
		}
		
	}

	public ResponseEntity<ResponseStructure<Employee>> updateAddress(int id, String address) 
	{
		Employee employee=dao.findEmployee(id);
		ResponseStructure<Employee>structure=new ResponseStructure<Employee>();
		if(employee!=null)
		{
			employee.setAddress(address);
			structure.setMessage("updated successfully!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateEmployee(id, employee));
			return new ResponseEntity(structure, HttpStatus.OK);
		}else {
			throw new IdNotFound("id not found");
		}
		
		
	}

	public ResponseEntity<ResponseStructure<Employee>> updateSalary(int id, double salary) 
	{
		Employee employee=dao.findEmployee(id);
		ResponseStructure<Employee>structure=new ResponseStructure<Employee>();
		if(employee!=null)
		{
			employee.setSalary(salary);
			
			if(salary<10000)
			{
				employee.setGrade('A');
			}else if(salary>=10000 && salary<20000)
			{
				employee.setGrade('B');
			}else if(salary>=20000 && salary<40000)
			{
				employee.setGrade('C');
			}else {
				employee.setGrade('D');
			}
			structure.setMessage("updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateEmployee(id, employee));
			
			return new ResponseEntity(structure, HttpStatus.OK);
		}else {
			throw new IdNotFound("id not found");
		}
		
		
	}
	public ResponseEntity<ResponseStructure<Employee>> findByEmail(String email)
	{
		Employee employee=dao.findByEmail(email);
		ResponseStructure<Employee>structure=new ResponseStructure<Employee>();
		if(employee!=null)
		{
			structure.setMessage("found successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(employee);
			
			return new ResponseEntity(structure, HttpStatus.FOUND);
		}else {
			throw new EmailNotPresent("email not present");
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Employee>> findByPhone(long phone)
	{
		Employee employee=dao.findByPhone(phone);
		ResponseStructure<Employee>structure=new ResponseStructure<Employee>();
		if(employee!=null)
		{
			structure.setMessage("found successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(employee);
			
			return new ResponseEntity(structure, HttpStatus.FOUND);
		}else {
			throw new PhoneNotPresent("phone number not presnt");
		}
		
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmpGreaterSal(double salary)
	{
		List<Employee>list=dao.findEmpGreaterSal(salary);
		ResponseStructure<List<Employee>>structure=new ResponseStructure<List<Employee>>();
		if(list.isEmpty())
		{
			throw new NotInRange("not in range");
		}else {
			structure.setMessage("Found Successfull!");
			 structure.setStatus(HttpStatus.FOUND.value());
			 structure.setData(list);
			 
			 return new ResponseEntity(structure, HttpStatus.FOUND);
		}
		
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmpLessSal(double salary)
	{
		List<Employee>list=dao.findEmpLessSal(salary);
		ResponseStructure<List<Employee>>structure=new ResponseStructure<List<Employee>>();
		if(list.isEmpty())
		{
			throw new NotInRange("not in range");
		}else {
			structure.setMessage("Found Successfull!");
			 structure.setStatus(HttpStatus.FOUND.value());
			 structure.setData(list);
			 
			 return new ResponseEntity(structure, HttpStatus.FOUND);
		}
		
	}
}
