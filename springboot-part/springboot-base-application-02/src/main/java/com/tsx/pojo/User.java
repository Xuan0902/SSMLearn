package com.tsx.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-09-27
 * @description:
 **/

/*
读取配置的方式1: @Value
            直接可以在属性上添加即可
            @Value(key必须写余了)
            @value只能读取单个值
    批量配置读取:
 */

@Data
@ConfigurationProperties(prefix = "tsx.user")   //批量赋值
@Component
public class User {
    // @Value("${tsx.user.username}")
    private String username;
    // @Value("${tsx.user.password}")
    private String password;
    // @Value("${tsx.user.gfs}")
    private List<String> gfs;
}
