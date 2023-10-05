package cn.tsx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author: ShengXuan
 * @create: 2023-09-26
 * @description: 业务层配置类：service，aop，tx
 * <p>
 * 1.开启aop注解支持
 * 2.tx声明式事务管理器
 **/

@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan("cn.tsx.service")
public class ServiceJavaConfig {
    // 添加jdbc事务管理器
    @Bean
    public TransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
