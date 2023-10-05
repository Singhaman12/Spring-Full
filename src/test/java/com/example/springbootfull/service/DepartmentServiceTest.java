package com.example.springbootfull.service;

import com.example.springbootfull.entity.Department;
import com.example.springbootfull.repo.DepartmentRepo;
import lombok.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoPostProcessor;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepo departmentRepo;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Punjab")
                .departmentCode("It08")
                .departmentId(3L)
                .build();
        Mockito.when(departmentRepo.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get a Valid Result")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName= "IT";
        Department found = departmentService.findByDeptName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
}