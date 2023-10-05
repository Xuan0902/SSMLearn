package cn.tsx.mapper;

import cn.tsx.pojo.Employee;

import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-09-24
 * @description: 员工mapper
 **/

public interface EmployeeMapper {
    List<Employee> queryList();
}
