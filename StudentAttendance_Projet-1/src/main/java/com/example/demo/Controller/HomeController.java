package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.Employee;
import com.example.demo.Service.EmployeeImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private EmployeeImpl empservice;
	
	 @GetMapping("/")
		public String index(Model model) {
		 List<Employee> list =empservice.getAllemp();
		 model.addAttribute("empList", list);
			return "index";
		}
	    @GetMapping("/loadEmpsave")
	    public String loadEmpsave() {
	    	return "emp_save";
	    }
	    @GetMapping("/EditEmp/{id}")
	    public String EditEmp(@PathVariable int id,Model model) {
	    	Employee emp  = empservice.getEmpbyId(id); 
	    	model.addAttribute("emp", emp);
	    	return "edit_emp";
	    }
	    @PostMapping("/saveEmp")
	    public String saveEmp(@ModelAttribute Employee emp,HttpSession session) {
	    	Employee emp1 = empservice.saveEmp(emp);
	    //	System.out.println(emp);
	    	if(emp1!=null) {
	    	session.setAttribute("msg", "Register Successfully");
	    	}else {
	    		session.setAttribute("msg", "something went wrong on server");
	    	}
	    	return "redirect:/loadEmpsave";
	    }
	    @PostMapping("/updateEmployeedetails")
	    public String updateEmp(@ModelAttribute Employee emp,HttpSession session) {
	    	Employee updateEmp = empservice.saveEmp(emp);
	    //	System.out.println(emp);
	    	if(updateEmp!=null) {
	    	session.setAttribute("msg", "Updated Successfully");
	    	}else {
	    		session.setAttribute("msg", "something went wrong on server");
	    	}
	    	return "redirect:/";
	}
	    @GetMapping("/deleteEmp/{id}")
	    public String loadEmpdelete(@PathVariable int id,HttpSession session) {
	    	boolean bn=empservice.deleteEmp(id);
	    	if(bn) {
	    		session.setAttribute("msg", "Delete successfully");
	    	}else {
	    		session.setAttribute("msg","something went wrong on server");
	    	}
	    	return "redirect:/";
	    }
}

