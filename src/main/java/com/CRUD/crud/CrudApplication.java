package com.CRUD.crud;

import com.CRUD.crud.model.Employee;
import com.CRUD.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

//	@Override
//	public void run(String args) throws Exception {
//		Employee employee = new Employee();
//		employee.setFirstname("Ashutosh");
//		employee.setLastname("Singh");
//		employee.setEmailId("ashu@gmail.com");
//        employeeRepository.save(employee);
//
//		Employee employee1 = new Employee();
//		employee.setFirstname("gunjan");
//		employee.setLastname("rai");
//		employee.setEmailId("rai@gmail.com");
//		employeeRepository.save(employee);
//
//
//	}


	@Override
	public void run(String... args) throws Exception {

		Employee employee = new Employee();
		employee.setFirstname("Ashutosh");
		employee.setLastname("Singh");
		employee.setEmailId("ashu@gmail.com");
		employeeRepository.save(employee);

		Employee employee1 = new Employee();
		employee.setFirstname("gunjan");
		employee.setLastname("rai");
		employee.setEmailId("rai@gmail.com");
		employeeRepository.save(employee);

	}
}

