package com.tsx.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    private Long id;

    private String name;

    private Integer age;

    private String email;

    private Integer deleted;

    private Integer version;

    private static final long serialVersionUID = 1L;
}