package cn.tsx.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-09-23
 * @description: 客户实体类
 **/

@Data
public class Customer {
    private Integer customerId;
    private String customerName;
    // 订单信息 对多
    private List<Order> orderList;
}
