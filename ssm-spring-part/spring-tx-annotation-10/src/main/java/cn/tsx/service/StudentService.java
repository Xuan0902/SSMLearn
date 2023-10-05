package cn.tsx.service;

import cn.tsx.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    /*
    readonly 只读模式
    timeout 设置超时时间 超过时间就会回滚事务 释放资源 抛出异常
    rollbackFor 指定异常回滚

    隔离级别设置：
        1. 读未提交（Read Uncommitted）：事务可以读取未被提交的数据，容易产生脏读、不可重复读和幻读等问题。实现简单但不太安全，一般不用。
        2. 读已提交（Read Committed）：事务只能读取已经提交的数据，可以避免脏读问题，但可能引发不可重复读和幻读。
        3. 可重复读（Repeatable Read）：在一个事务中，相同的查询将返回相同的结果集，不管其他事务对数据做了什么修改。可以避免脏读和不可重复读，但仍有幻读的问题。
        4. 串行化（Serializable）：最高的隔离级别，完全禁止了并发，只允许一个事务执行完毕之后才能执行另一个事务。可以避免以上所有问题，但效率较低，不适用于高并发场景。
     */

    @Transactional(timeout = 3, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
    public void changeInfo() {
        studentDao.updateAgeById(10, 1);
        int i = 1 / 0;
        System.out.println("-----------");
        studentDao.updateNameById("test2", 1);
    }

    /**
     * 声明两个独立修改数据库的事务业务方法
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void changeAge(){
        studentDao.updateAgeById(998,1);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void changeName(){
        studentDao.updateNameById("二狗子",1);
//        int i = 1/0;
    }
}
