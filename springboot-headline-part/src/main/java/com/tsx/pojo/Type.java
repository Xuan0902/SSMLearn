package com.tsx.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.beans.Transient;
import java.io.Serializable;

import lombok.Data;

/**
 * @TableName news_type
 */
@Data
public class Type implements Serializable {
    @TableId
    private Integer tid;

    private String tname;

    @Version
    private Integer version;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}