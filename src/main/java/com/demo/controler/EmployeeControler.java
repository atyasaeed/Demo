package com.demo.controler;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.EmployeeVO;
import com.demo.entity.Employee;
import com.demo.service.EmployeeService;
import com.sipios.springsearch.anotation.SearchSpec;

@RestController
@RequestMapping("/api")
public class EmployeeControler {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/add")
	public ResponseEntity<Employee> add(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.add(employee), HttpStatus.OK);

	}

	@GetMapping("emps")
	public List<Employee> findAllByName(@RequestParam String name) {
		return employeeService.findAllByName(name);

	}

	@GetMapping("empssalary")
	public List<Employee> findAllByNameAndSalary(@RequestParam String name, @RequestParam double salary) {

		return employeeService.findAllByNameAndSalary(name, salary);

	}

	@GetMapping("/empssalaryless")
	public List<Employee> findAllByNameAndSalary(@RequestParam double salary) {
		return employeeService.findAllBySalaryLessThan(salary);

	}

	@GetMapping("/JQL")
	public ResponseEntity<Employee> findByJPQL(@RequestParam Integer id) {
		Employee emp = null;
		if (id != null) {

			emp = employeeService.findByJPQL(id);
		}

		return new ResponseEntity<Employee>(emp, HttpStatus.OK);

	}

	@GetMapping("/salaryRange")
	public List<Employee> findAllRangeSalary(@RequestParam double minSalary, @RequestParam double maxSalary) {
		return employeeService.findEmployeeRangeSalary(minSalary, maxSalary);

	}

//	@GetMapping("/spec")
//	public Page<Employee> findAllPages(@RequestParam double empSalary, @RequestParam int size,
//			@RequestParam int pages) {
//		PageRequest page = PageRequest.of(pages, size);
//		return employeeService.findAllPages(empSalary, page);
//
//	}
	@GetMapping("/spec")
	public Page<Employee> findAllPages(@SearchSpec Specification<Employee> specs,
			@PageableDefault(page = 0, size = 10, sort = "empSalary") Pageable page) {

		return employeeService.findAllPages(specs, page);

	}

	@GetMapping("/projection")
	public List<EmployeeVO> findAllProjcted() {
		return employeeService.findAllProjcted();
	}

	@GetMapping("/projectionby")
	public List<EmployeeVO> findAllProjctedByname(@RequestParam String name) {
		return employeeService.findAllProjctedByName(name);
	}

	@GetMapping("/asso")
	public List<Employee> findByEmployeeTypee(@RequestParam String type) {
		return employeeService.findByEmployeeType(type);

	}
}
