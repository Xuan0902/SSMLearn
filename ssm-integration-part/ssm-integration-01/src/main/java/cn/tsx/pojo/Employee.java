package cn.tsx.pojo;

import lombok.Data;

/**
 * @author: ShengXuan
 * @create: 2023-09-26
 * @description: 员工实体类
 **/

@Data
public class Employee {

    private Integer empId;
    private String empName;
    private Double empSalary;
}
