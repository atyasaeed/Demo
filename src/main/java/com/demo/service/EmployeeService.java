package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.demo.EmployeeVO;
import com.demo.entity.Employee;
import com.demo.repositry.EmployeeRepo;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	EmployeeRepo employeeRepo;

	public Employee add(Employee employee) {

		return employeeRepo.save(employee);

	}

	public List<Employee> findAllByName(String name) {
		return employeeRepo.findAllByEmpName(name);

	}

	public List<Employee> findAllByNameAndSalary(String name, double salary) {
		return employeeRepo.findAllByEmpNameAndEmpSalary(name, salary);

	}

	public List<Employee> findAllBySalaryLessThan(double salary) {
		return employeeRepo.findAllByEmpSalaryLessThan(salary);

	}

	public Employee findByJPQL(Integer id) {
		return employeeRepo.findEmployeeByIdJQL(id);

	}

	public List<Employee> findEmployeeRangeSalary(double minSalary, double maxSalary) {
		return employeeRepo.findEmployeeBetweenRange(minSalary, maxSalary);

	}

	//////// Holding to modification
	public Page<Employee> findAllPages(Specification<Employee> specs, Pageable page) {
		Employee empSalary = new Employee();
		return employeeRepo.findAll(filterBySalary(empSalary.getEmpSalary()).and(specs), page);

	}

	public Specification<Employee> filterBySalary(double empSalary) {

		return (Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			predicates.add(cb.equal(root.<Employee>get("empSalary"), empSalary));
			return cb.and(predicates.toArray(new Predicate[predicates.size()]));
		};

	}

	public List<EmployeeVO> findAllProjcted() {
		return employeeRepo.findAllProjectedBy();
	}

	public List<EmployeeVO> findAllProjctedByName(String empName) {

		return employeeRepo.findAllProjectedByempName(empName);
	}

	public List<Employee> findByEmployeeType(String type) {
		return employeeRepo.findAllByEmployeeIdType(type);

	}


}
