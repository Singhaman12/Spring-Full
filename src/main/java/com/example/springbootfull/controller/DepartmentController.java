package com.example.springbootfull.controller;

import com.example.springbootfull.entity.Department;
import com.example.springbootfull.error.DepartmentNotFoundException;
import com.example.springbootfull.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
 public class DepartmentController {

 @Autowired
 private DepartmentService departmentService;

 @PostMapping("/departments")
 public Department saveDepartment( @Valid @RequestBody Department department){
  return departmentService.saveDept(department);
 }

 @GetMapping("/departments")
 public List<Department> getDepartment(){
  return departmentService.getDept();
 }

 @GetMapping("/departments/{id}")
 public Department getDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
  return departmentService.getDeptById(id);
 }

 @DeleteMapping("/departments/{id}")
 public void deleteById(@PathVariable ("id") Long id){
  departmentService.deleteDeptById(id);
 }

 @PutMapping("/departments/{id}")
 public Department updateDepartment(@RequestBody Department department, @PathVariable ("id") Long id){
  return departmentService.updateDept(department,id);
 }

 @GetMapping("/departments/name/{name}")
 public Department findByDepartmentName( @PathVariable ("name") String departmentName){
  return departmentService.findByDeptName(departmentName);
 }
}
