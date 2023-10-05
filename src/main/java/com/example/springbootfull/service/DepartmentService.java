package com.example.springbootfull.service;

import com.example.springbootfull.entity.Department;
import com.example.springbootfull.error.DepartmentNotFoundException;
import com.example.springbootfull.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public Department saveDept(Department department){
        return departmentRepo.save(department);
    }

    public List<Department> getDept() {
        return departmentRepo.findAll();
    }

    public Department getDeptById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department=departmentRepo.findById(id);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Found");
        }
        return department.get();
    }

    public void deleteDeptById(Long id) {
        departmentRepo.deleteById(id);
    }

    public Department updateDept(Department department, Long id) {
       Department d = departmentRepo.findById(id).get();
       if(Objects.nonNull(department.getDepartmentName())&& !"".equalsIgnoreCase(department.getDepartmentName())) {
           d.setDepartmentName(department.getDepartmentName());
       }

        if(Objects.nonNull(department.getDepartmentCode())&& !"".equalsIgnoreCase(department.getDepartmentCode())) {
            d.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress())&& !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            d.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepo.save(d);
    }

    public Department findByDeptName(String departmentName) {
        return departmentRepo.findByDepartmentNameIgnoreCase(departmentName);
    }
}
