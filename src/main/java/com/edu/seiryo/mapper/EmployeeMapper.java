package com.edu.seiryo.mapper;

import com.edu.seiryo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface EmployeeMapper {
    // 获取所有员工信息
    public List<Employee> getEmployees();
    // 新增一个员工
    public int save(Employee employee);
    // 通过id获得员工信息
    public Employee get(@Param("id") Integer id);
    // 通过id删除员工
    public void delete(@Param("id") Integer id);
    int update(Employee employee);
}
