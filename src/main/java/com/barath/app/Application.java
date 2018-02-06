package com.barath.app;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SpringBootApplication
@RestController
public class Application
{

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/")
	public String home()
	{
		return "Welcome to Spring boot-My-SQL-Openshift";
	}

	@GetMapping("/emp/get/{empId}")
	public Employee getEmployee(@PathVariable Long employeeId)
	{
		return employeeService.getEmployee(employeeId);

	}

	@PostMapping("/emp/create")
	public Employee createEmployee(@RequestBody Employee emp)
	{
		employeeService.saveEmployee(emp);
		return emp;

	}

	@Service
	protected static class EmployeeService
	{

		private EmployeeRepository empRep;

		@Autowired
		public EmployeeService(EmployeeRepository empRep)
		{
			this.empRep = empRep;
		}

		public void saveEmployee(Employee employee)
		{
			empRep.save(employee);
		}

		public Employee getEmployee(Long employeeId)
		{

			return empRep.findOne(employeeId);
		}

	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	@Entity
	@Table(name = "EMPLOYEE")
	protected static class Employee
	{

		@Id
		@GeneratedValue
		private Long employeeId;

		private String employeeName;

		public Employee(Long employeeId, String employeeName)
		{
			super();
			this.employeeId = employeeId;
			this.employeeName = employeeName;
		}

		public Employee(String employeeName)
		{
			super();
			this.employeeName = employeeName;
		}

		public Employee()
		{
			super();

		}

		public long getEmployeeId()
		{
			return employeeId;
		}

		public void setEmployeeId(long employeeId)
		{
			this.employeeId = employeeId;
		}

		public String getEmployeeName()
		{
			return employeeName;
		}

		public void setEmployeeName(String employeeName)
		{
			this.employeeName = employeeName;
		}

		@Override
		public String toString()
		{
			return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + "]";
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
			result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			if (employeeId == null)
			{
				if (other.employeeId != null)
					return false;
			} else if (!employeeId.equals(other.employeeId))
				return false;
			if (employeeName == null)
			{
				if (other.employeeName != null)
					return false;
			} else if (!employeeName.equals(other.employeeName))
				return false;
			return true;
		}

	}
}
