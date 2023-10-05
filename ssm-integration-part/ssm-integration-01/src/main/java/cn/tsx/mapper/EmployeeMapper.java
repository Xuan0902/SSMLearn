package cn.tsx.mapper;

import cn.tsx.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-09-27
 * @description:
 **/

@Mapper
public interface EmployeeMapper {
    List<Employee> queryList();
}
