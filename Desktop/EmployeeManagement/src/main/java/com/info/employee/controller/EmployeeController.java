package com.info.employee.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.info.employee.daoimpl.EmployeeDaoImpl;
import com.info.employee.pojo.Employee;

@Controller
public class EmployeeController {
	public EmployeeController() {
		System.out.println("In constructor");
	}

	@RequestMapping("/")
	public String index() {
		System.out.println("In controller");
		return "index";
	}

	@RequestMapping("/back")
	public String back() {
		System.out.println("In Back Controller");
		return "index";
	}

	@RequestMapping("/insert")
	public String insert() {
		System.out.println("In Insert controller");
		return "insert";
	}

	@RequestMapping("/insertData")
	public String insertData(@ModelAttribute("test") Employee emp) {
		System.out.println(" I am in insert Controller");
		EmployeeDaoImpl insert = new EmployeeDaoImpl();
		Boolean b = insert.save(emp);
		System.out.println("Insert Data");

		if (b == true) {
			return "index";
		} else {
			return "insert";
		}
	}

	@RequestMapping("/view")
	public ModelAndView view() {
		EmployeeDaoImpl view = new EmployeeDaoImpl();
		List<Employee> emp = view.viewAllEmployees();
		for (Employee employeePojo : emp) {
			System.out.println(employeePojo);
		}
		return new ModelAndView("viewAll", "viewdata", emp);
	}

	@RequestMapping("/updatelink")
	public ModelAndView updatelink(@ModelAttribute("test") Employee emp) {
		EmployeeDaoImpl update = new EmployeeDaoImpl();
		List<Employee> employeeList = update.updatebyid(emp.getId());
		return new ModelAndView("viewById", "viewList", employeeList);
	}

	@RequestMapping("/update")
	public String update(@ModelAttribute("test") Employee emp) {

		EmployeeDaoImpl update = new EmployeeDaoImpl();
		int result = update.updatenewvalues(emp);
		if (result != 0) {
			return "redirect:view";
		} else {
			System.out.println("Not Updated");
			return "redirect:view";
		}

	}

	@RequestMapping("/deletebyid")
	public String deletebyid(@ModelAttribute("test") Employee emp) {

		EmployeeDaoImpl delete = new EmployeeDaoImpl();
		int b = delete.deletebyid(emp.getId());
		if (b != 0) {
			return "redirect:view";
		} else {
			System.out.println("Not Deleted");
			return "redirect:view";
		}
	}
}
