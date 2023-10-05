package cn.tsx.controller;

import cn.tsx.pojo.Schedule;
import cn.tsx.service.ScheduleService;
import cn.tsx.utils.PageBean;
import cn.tsx.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author: ShengXuan
 * @create: 2023-09-27
 * @description:
 **/

@CrossOrigin
@RestController
@RequestMapping("schedule")
@Slf4j
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("{pageSize}/{currentPage}")
    public R page(@PathVariable int pageSize,
                  @PathVariable int currentPage) {
        PageBean<Schedule> pageBean = scheduleService.page(pageSize, currentPage);
        log.info("查询到的数据为：{}", pageBean);
        return R.ok(pageBean);
    }

    @DeleteMapping("{id}")
    public R deleteById(@PathVariable int id) {
        log.info("要删除的id为：{}", id);
        return scheduleService.deleteById(id);
    }

    @PostMapping
    public R add(@Validated @RequestBody Schedule schedule, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return R.fail(null);
        }
        log.info("保存的为：{}", schedule);
        return scheduleService.add(schedule);
    }

    @PutMapping
    public R updateById(@RequestBody Schedule schedule) {
        log.info("修改的数据为：{}", schedule);
        return scheduleService.updateById(schedule);
    }

}
