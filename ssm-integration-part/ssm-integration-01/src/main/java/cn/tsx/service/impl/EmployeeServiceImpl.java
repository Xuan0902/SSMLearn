package cn.tsx.service.impl;

import cn.tsx.mapper.EmployeeMapper;
import cn.tsx.pojo.Employee;
import cn.tsx.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-09-27
 * @description:
 **/

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findAll() {
        return employeeMapper.queryList();
    }
}
