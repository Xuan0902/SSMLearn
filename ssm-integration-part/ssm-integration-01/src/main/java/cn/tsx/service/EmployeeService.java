package cn.tsx.service;

import cn.tsx.pojo.Employee;

import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-09-27
 * @description:
 **/

public interface EmployeeService {
    List<Employee> findAll();
}
