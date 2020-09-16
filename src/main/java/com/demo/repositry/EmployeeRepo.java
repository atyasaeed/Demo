package com.demo.repositry;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.EmployeeVO;
import com.demo.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {

	List<Employee> findAllByEmpName(String empName);

	List<Employee> findAllByEmpNameLike(String empName);

	List<Employee> findAllByEmpNameAndEmpSalary(String empName, double empSalary);

	List<Employee> findAllByEmpSalaryLessThan(double empSalary);

	@Query("select e from Employee e where e.id =?1")
	Employee findEmployeeByIdJQL(Integer EmpId);

	@Query("select e from Employee e where e.empSalary between ?1 and ?2")
	List<Employee> findEmployeeBetweenRange(double minSalary, double maxSalary);

	Page<Employee> findByEmpName(String empName, Pageable page);

	List<EmployeeVO> findAllProjectedBy();

	List<EmployeeVO> findAllProjectedByempName(String empName);

	// Associatian
	List<Employee> findAllByEmployeeIdType(String type);

}
