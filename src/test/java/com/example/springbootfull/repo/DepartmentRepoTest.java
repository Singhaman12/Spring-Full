package com.example.springbootfull.repo;

import com.example.springbootfull.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepoTest {
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department= Department.builder()
                .departmentName("Computer")
                .departmentAddress("Brampton")
                .departmentCode("Cse01")
                .build();
        entityManager.persist(department);
    }

    @Test
    @DisplayName("Find by Dept Name")
    public void whenfindbyidthenreturnDepartment(){
        Department department=departmentRepo.findById(1L).get();
        assertEquals(department.getDepartmentName(),"Computer");
    }

}