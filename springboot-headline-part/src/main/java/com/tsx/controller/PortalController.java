package com.tsx.controller;

import com.tsx.common.dto.PortalDTO;
import com.tsx.pojo.Headline;
import com.tsx.service.HeadlineService;
import com.tsx.service.TypeService;
import com.tsx.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-10-01
 * @description:
 **/

@RestController
@RequestMapping("portal")
@CrossOrigin
public class PortalController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private HeadlineService headlineService;

    @GetMapping("findAllTypes")
    public Result findAllTypes() {
        Result result = typeService.findAllTypes();
        return result;
    }

    @PostMapping("findNewsPage")
    public Result findNewsPage(@RequestBody PortalDTO portalDTO) {
        Result result = headlineService.findNewPage(portalDTO);
        return result;
    }

    @PostMapping("showHeadlineDetail")
    public Result showHeadlineDetail(Integer hid) {
        Result result = headlineService.showHeadlineDetail(hid);
        return result;
    }
}
