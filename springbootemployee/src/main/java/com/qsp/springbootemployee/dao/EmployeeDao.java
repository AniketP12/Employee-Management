package com.qsp.springbootemployee.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springbootemployee.dto.Employee;
import com.qsp.springbootemployee.repo.EmployeeRepo;

@Repository
public class EmployeeDao 
{
	@Autowired
	private EmployeeRepo repo;
	
	public Employee saveEmployee(Employee employee) 
	{
		return repo.save(employee);
	}
	public Employee findEmployee(int id)
	{
//		return repo.findById(id).get();
		/* to avoid NoSuchElementException*/
		
		Optional<Employee>o=repo.findById(id);
		if(o.isPresent())
		{
			return o.get();
		}else {
			return null;
		}
//		if(o.isEmpty())
//		{
//			return null;
//		}else {
//			return o.get();
//		}
	}
	public List<Employee> getAllEmployee() 
	{
		return repo.findAll();
	}
	
	public Employee deleteEmployee(int id) 
	{
		Optional<Employee>o=repo.findById(id);
		if(o.isPresent())
		{
			repo.deleteById(id);
			return o.get();
		}
		return null;
		
		/*if(o.isPresent)
		  {
		  		Employee e=o.get();
		  		repo.delete(e);
		  		return e;
		  } else{
		  		return null;
		  }
		  	
		  */
	}
	public Employee updateEmployee(int id,Employee employee) 
	{
		Optional<Employee>optional=repo.findById(id);
		if(optional.isEmpty())
		{
			return null;
		}
		employee.setId(id);
		repo.save(employee);
		return optional.get();
	}
	public Employee findByEmail(String email) 
	{
		return repo.findEmployeeByEmail(email);
	}
	public Employee findByPhone(long phone) 
	{
		return repo.empByPhone(phone);
	}
	public List<Employee> findEmpGreaterSal(double salary) 
	{
		return repo.findEmployeeBySalaryGreaterThan(salary);
	}
	
	public List<Employee> findEmpLessSal(double salary)
	{
		return repo.findEmployeeBySalaryLessThan(salary);
	}
}
