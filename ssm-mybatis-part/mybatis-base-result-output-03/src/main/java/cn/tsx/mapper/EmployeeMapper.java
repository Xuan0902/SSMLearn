package cn.tsx.mapper;


import cn.tsx.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    // 如果是dml语句（插入 修改 删除）
    int deleteById(Integer id);

    // 指定输出类型 查询语句
    // 根据员工id查找姓名
    String queryNameById(Integer id);

    // 根据员工id查找工资
    Double querySalaryById(Integer id);

    // Map<String, Object> selectEmpNameAndMaxSalary();

    // 查询工资高于指定值的员工们 200
    List<Employee> queryNamesBySalary(Double salary);

    // 查询全部员工信息
    List<Employee> queryAll();

    // 员工插入
    int insertEmp(Employee employee);
}
