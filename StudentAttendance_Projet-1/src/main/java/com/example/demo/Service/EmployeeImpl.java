package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmployeeRepository;

import jakarta.servlet.http.HttpSession;


  @Service
public class EmployeeImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public Employee saveEmp(Employee emp) {
	  Employee newEmp = empRepo.save(emp);
		return newEmp;
	}

	@Override
	public List<Employee> getAllemp() {
		
		return empRepo.findAll();
	}

	@Override
	public Employee getEmpbyId(int id) {
		
		return empRepo.findById(id).get();
	}

	@Override
	public boolean deleteEmp(int id) {
		Employee emp =empRepo.findById(id).get();
		if(emp!=null) {
			empRepo.delete(emp);
			return true;
		}
		return false ;
	}
	public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
		session.removeAttribute("msg");
	}


}
