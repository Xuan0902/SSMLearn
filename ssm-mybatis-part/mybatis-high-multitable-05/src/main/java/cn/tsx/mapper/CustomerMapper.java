package cn.tsx.mapper;

import cn.tsx.pojo.Customer;
import lombok.Data;

import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-09-23
 * @description: 客户的方法
 **/

public interface CustomerMapper {
    // 查询所有客户信息 以及客户订单的信息
    List<Customer> queryList();
}
