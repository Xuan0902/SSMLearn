package com.tsx.common.dto;

import lombok.Data;

/**
 * @author: ShengXuan
 * @create: 2023-10-01
 * @description:
 **/

@Data
public class PortalDTO {
    private String keyWords;
    private int type = 0;
    private int pageNum = 1;
    private int pageSize = 10;
}
