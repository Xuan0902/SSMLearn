package com.tsx.test;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tsx.common.dto.PortalDTO;
import com.tsx.mapper.HeadlineMapper;
import com.tsx.pojo.Headline;
import com.tsx.utils.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HeadlineServiceImplTest {
    @Autowired
    private HeadlineMapper headlineMapper;

    @Test
    public void findNewPage() {
        PortalDTO portalDTO = new PortalDTO();
        portalDTO.setKeywords("高");
        portalDTO.setType(0);
        portalDTO.setPageNum(1);
        portalDTO.setPageSize(10);
        IPage<Headline> page = new Page<>(portalDTO.getPageNum(), portalDTO.getPageSize());
        // 条件拼接
        // LambdaQueryWrapper<Headline> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // lambdaQueryWrapper.like(StringUtils.isNotBlank(portalDTO.getKeywords()), Headline::getArticle, portalDTO.getKeywords())
        //         .eq(Headline::getType, portalDTO.getType());
        headlineMapper.selectMyPage(page, portalDTO);
        List<Headline> headlines = page.getRecords();
        System.out.println("headlines = " + headlines);
    }
}