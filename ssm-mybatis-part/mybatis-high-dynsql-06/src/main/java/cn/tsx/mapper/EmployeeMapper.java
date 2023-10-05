package cn.tsx.mapper;

import cn.tsx.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-09-23
 * @description: 员工接口方法
 **/


public interface EmployeeMapper {
    // 根据员工的姓名和工资查询员工
    List<Employee> query(@Param("name") String name, @Param("salary") Double salary);

    // 根据id更新
    int update(Employee employee);

    // 如果姓名不为空 按照姓名，如果薪水不为空 按照薪水，如果两个都为空 查全部
    List<Employee> queryChoose(@Param("name") String name, @Param("salary") Double salary);

    // 根据id的批量查询
    List<Employee> queryBatch(@Param("ids") List<Integer> ids);

    // 根据id的批量删除
    int deleteBatch(@Param("ids") List<Integer> ids);

    // 批量插入
    int insertBatch(@Param("list") List<Employee> employeeList);

    // 批量修改
    int updateBatch(@Param("list") List<Employee> employeeList);
}
