package com.tsx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tsx.common.dto.HeadlineDTO;
import com.tsx.common.dto.PortalDTO;
import com.tsx.pojo.Headline;
import com.tsx.service.HeadlineService;
import com.tsx.mapper.HeadlineMapper;
import com.tsx.utils.JwtHelper;
import com.tsx.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xuan
 * @description 针对表【news_headline】的数据库操作Service实现
 * @createDate 2023-09-30 20:49:17
 */
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
        implements HeadlineService {

    @Autowired
    private HeadlineMapper headlineMapper;
    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public Result findNewPage(PortalDTO portalDTO) {
        IPage<Headline> page = new Page<>(portalDTO.getPageNum(), portalDTO.getPageSize());
        headlineMapper.selectMyPage(page, portalDTO);
        List<Headline> headlines = page.getRecords();
        HashMap<String, Object> pageInfo = new HashMap<>();
        pageInfo.put("pageData", headlines);
        pageInfo.put("pageNum", page.getCurrent());
        pageInfo.put("pageSize", page.getSize());
        pageInfo.put("totalPage", page.getPages());
        pageInfo.put("totalSize", page.getTotal());
        return Result.ok(Map.of("pageInfo", pageInfo));
    }

    @Override
    public Result showHeadlineDetail(Integer hid) {
        System.out.println("hid = " + hid);
        Map<String, Object> map = headlineMapper.selectDetailMap(hid);
        System.out.println("map = " + map);
        // 修改阅读量+1
        Integer pageViews = (Integer) map.get("pageViews");
        Integer version = (Integer) map.get("version");
        Headline headline = new Headline();
        headline.setHid(hid);
        headline.setPageViews(pageViews + 1);
        headline.setVersion(version);
        headlineMapper.updateById(headline);
        return Result.ok(Map.of("headline", map));
    }

    @Override
    public Result publish(Headline headline, String token) {
        // 根据token查id
        int userId = jwtHelper.getUserId(token).intValue();
        // 数据装配
        headline.setPublisher(userId);
        headline.setPageViews(0);
        headline.setCreateTime(new Date());
        headline.setUpdateTime(new Date());
        headlineMapper.insert(headline);
        return Result.ok(null);
    }

    @Override
    public Result findHeadlineByHid(int hid) {
        Headline headline = headlineMapper.selectById(hid);
        Map<String, ? extends Serializable> headlineMap = Map.of(
                "hid", headline.getHid(),
                "title", headline.getTitle(),
                "article", headline.getArticle(),
                "type", headline.getType());
        return Result.ok(Map.of("headline", headlineMap));
    }

    @Override
    public Result updateHeadline(Headline headline) {
        Integer version = headlineMapper.selectById(headline.getHid()).getVersion();
        headline.setVersion(version);
        headline.setUpdateTime(new Date());
        headlineMapper.updateById(headline);
        return Result.ok(null);
    }
}




