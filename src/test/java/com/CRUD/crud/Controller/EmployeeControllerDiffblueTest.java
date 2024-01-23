package com.CRUD.crud.Controller;

import static org.mockito.Mockito.when;

import com.CRUD.crud.exception.ResourceNotFoundException;
import com.CRUD.crud.model.Employee;
import com.CRUD.crud.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {EmployeeController.class})
@ExtendWith(SpringExtension.class)
class EmployeeControllerDiffblueTest {
    @Autowired
    private EmployeeController employeeController;

    @MockBean
    private EmployeeRepository employeeRepository;

    /**
     * Method under test: {@link EmployeeController#createEmployee(Employee)}
     */
    @Test
    void testCreateEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setEmailId("42");
        employee.setFirstname("Jane");
        employee.setId(1L);
        employee.setLastname("Doe");
        when(employeeRepository.save(Mockito.<Employee>any())).thenReturn(employee);

        String content = (new ObjectMapper()).writeValueAsString(employee);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/employees/course")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":1,\"firstname\":\"Jane\",\"lastname\":\"Doe\",\"emailId\":\"42\"}"));
    }

    /**
     * Method under test:  {@link EmployeeController#createEmployee(Employee)}
     */
    @Test
    void testCreateEmployee2() throws Exception {
        when(employeeRepository.save(Mockito.<Employee>any()))
                .thenThrow(new ResourceNotFoundException("An error occurred"));

        Employee employee = new Employee();
        employee.setEmailId("42");
        employee.setFirstname("Jane");
        employee.setId(1L);
        employee.setLastname("Doe");
        String content = (new ObjectMapper()).writeValueAsString(employee);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/employees/course")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link EmployeeController#createEmployee(Employee)}
     */
    @Test
    void testCreateEmployee3() throws Exception {
        Employee employee = new Employee();
        employee.setEmailId("42");
        employee.setFirstname("Jane");
        employee.setId(1L);
        employee.setLastname("Doe");
        when(employeeRepository.save(Mockito.<Employee>any())).thenReturn(employee);

        Employee employee2 = new Employee();
        employee2.setEmailId("42");
        employee2.setFirstname("Jane");
        employee2.setId(1L);
        employee2.setLastname("Doe");
        String content = (new ObjectMapper()).writeValueAsString(employee2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/employees/course")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":1,\"firstname\":\"Jane\",\"lastname\":\"Doe\",\"emailId\":\"42\"}"));
    }
}
