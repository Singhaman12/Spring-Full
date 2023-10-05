package com.example.springbootfull.controller;

import com.example.springbootfull.entity.Department;
import com.example.springbootfull.error.DepartmentNotFoundException;
import com.example.springbootfull.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService service;
    private Department department;
    @BeforeEach
    void setUp() {
      department= Department.builder()
              .departmentId(1L)
              .departmentCode("IT06")
              .departmentAddress("Chennai")
              .departmentName("IT")
              .build();
    }
    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment= Department.builder()
                .departmentCode("IT06")
                .departmentAddress("Chennai")
                .departmentName("IT")
                .build();
        Mockito.when(service.saveDept(inputDepartment)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n"+
                        "\t\"departmentName\":\"IT\",\n"+
                         "\t\"departmentAddress\":\"Chennai\",\n"+
                          "\t\"departmentCode\":\"IT06\"\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getDepartmentById() throws Exception {
     Mockito.when(service.getDeptById(1L)).thenReturn(department);

     mockMvc.perform(MockMvcRequestBuilders.get("/api/departments/1")
             .contentType(MediaType.APPLICATION_JSON))
             .andExpect(MockMvcResultMatchers.status().isOk())
             .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}