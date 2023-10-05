package com.tsx.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HeadlineMapperTest {
    @Autowired
    private HeadlineMapper headlineMapper;

    @Test
    void selectDetailMap() {
        Map<String, Object> map = headlineMapper.selectDetailMap(1);
        System.out.println("map = " + map);
    }
}