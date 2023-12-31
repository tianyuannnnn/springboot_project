package com.edu.seiryo.controller;

import com.edu.seiryo.entity.Department;
import com.edu.seiryo.entity.Employee;
import com.edu.seiryo.mapper.DepartmentMapper;
import com.edu.seiryo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class EmployeeController {
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    //查询所有员工，返回列表页面
    @GetMapping("/emps")
    public String list(Model model) {
        List<Employee> employees = employeeMapper.getEmployees();
        //将结果放在请求中
        model.addAttribute("emps", employees);
        return "emp/list";
    }
    //跳转到添加员工页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //查出所有的部门，提供选择
        List<Department> departments = departmentMapper.getDepartments();
        System.out.println(departments);
        model.addAttribute("departments", departments);
        return "emp/add";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        // 回到员工列表页面，可以使用redirect或者forward，就不会被视图解析器解析
        System.out.println("add");
        employeeMapper.save(employee);
        return "redirect:/emps";
    }
    //to员工修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model) {
        //根据id查出来员工
        Employee employee = employeeMapper.get(id);
        System.out.println(employee);
        //将员工信息返回页面
        model.addAttribute("emp", employee);
        //查出所有的部门，提供修改选择
        List<Department> departments = departmentMapper.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/update";
    }
    @PutMapping("/emp")
    public String updateEmp(Employee employee) {
        System.out.println("update");
        employeeMapper.update(employee);
        //回到员工列表页面
        return "redirect:/emps";
    }
    @DeleteMapping("/emp/{id}")
    public String delEmp(@PathVariable("id") Integer id) {
        employeeMapper.delete(id);
        return "redirect:/emps";
    }
}
