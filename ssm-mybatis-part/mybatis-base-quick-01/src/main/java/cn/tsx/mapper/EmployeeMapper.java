package cn.tsx.mapper;

import cn.tsx.pojo.Employee;

public interface EmployeeMapper {
    /*
    根据id返回员工信息
     */
    Employee queryById(Integer id);

    /*
    根据id删除
     */
    int deleteById(Integer id);
}
