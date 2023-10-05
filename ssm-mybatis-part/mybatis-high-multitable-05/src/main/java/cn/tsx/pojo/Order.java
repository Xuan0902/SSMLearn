package cn.tsx.pojo;

import lombok.Data;

/**
 * @author: ShengXuan
 * @create: 2023-09-23
 * @description: 商品实体类
 **/

@Data
public class Order {
    private Integer orderId;
    private String orderName;
    private Integer customerId;
    // 一个订单对应一个客户 对一
    private Customer customer;
}
