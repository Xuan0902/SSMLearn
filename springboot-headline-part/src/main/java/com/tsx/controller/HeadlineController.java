package com.tsx.controller;

import com.tsx.common.dto.HeadlineDTO;
import com.tsx.pojo.Headline;
import com.tsx.service.HeadlineService;
import com.tsx.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: ShengXuan
 * @create: 2023-10-01
 * @description:
 **/

@RestController
@RequestMapping("headline")
public class HeadlineController {
    @Autowired
    private HeadlineService headlineService;

    @PostMapping("publish")
    public Result publish(@RequestBody Headline headline, @RequestHeader String token) {
        Result result = headlineService.publish(headline, token);
        return Result.ok(result);
    }

    @PostMapping("findHeadlineByHid")
    public Result findHeadlineByHid(int hid) {
        Result result = headlineService.findHeadlineByHid(hid);
        return result;
    }

    @PostMapping("update")
    public Result update(@RequestBody Headline headline) {
        Result result = headlineService.updateHeadline(headline);
        return result;
    }

    @PostMapping("removeByHid")
    public Result removeByHid(Integer hid) {
        headlineService.removeById(hid);
        return Result.ok(null);
    }
}
