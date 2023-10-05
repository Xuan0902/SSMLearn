package cn.tsx.mapper;

import cn.tsx.pojo.Order;

public interface OrderMapper {
    // 根据id查询订单和订单对应的客户信息
    Order queryOrderById(Integer orderId);
}