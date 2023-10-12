package com.CRUD.crud.repository;

import com.CRUD.crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    //crud database methods
}

