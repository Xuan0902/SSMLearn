package com.tsx.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * @author: ShengXuan
 * @create: 2023-09-29
 * @description: user
 **/
@Data
@Builder
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
