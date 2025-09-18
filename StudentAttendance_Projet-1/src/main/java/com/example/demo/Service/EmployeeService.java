package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Employee;

public interface EmployeeService {
	
public Employee saveEmp(Employee emp);

public List<Employee> getAllemp();

public Employee getEmpbyId(int id);

public boolean deleteEmp(int id);
}
