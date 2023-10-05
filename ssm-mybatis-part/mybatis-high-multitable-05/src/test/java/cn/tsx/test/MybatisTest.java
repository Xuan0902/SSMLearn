package cn.tsx.test;

import cn.tsx.mapper.CustomerMapper;
import cn.tsx.mapper.OrderMapper;
import cn.tsx.pojo.Customer;
import cn.tsx.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-09-23
 * @description: 测试多表查询
 **/


public class MybatisTest {
    private SqlSession sqlSession;

    @BeforeEach
    public void before() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @Test
    public void test_order() {
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Order order = mapper.queryOrderById(1);
        System.out.println("order = " + order);
        System.out.println(order.getCustomer());
    }

    @Test
    public void test_customer() {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customers = mapper.queryList();
        for (Customer customer : customers) {
            System.out.println("customer = " + customer);
            List<Order> orderList = customer.getOrderList();
            System.out.println("orderList = " + orderList);
        }
    }

    @AfterEach
    public void after() {
        sqlSession.close();
    }
}
