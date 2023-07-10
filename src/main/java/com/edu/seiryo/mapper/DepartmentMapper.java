package com.edu.seiryo.mapper;

import com.edu.seiryo.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    // 获取所有部门信息
    public List<Department> getDepartments();
    // 通过id获得部门
    public Department getDepartment(Integer id);
}
