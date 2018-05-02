package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.LogWithBLOBs;
import com.pojo.Page;
import com.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zhangjingyu
 */
@Controller
@RequestMapping("")
public class LogController {
    @Autowired
    LogService logService;

    @RequestMapping("operationLog")
    public ModelAndView operationLog(Page page){
        ModelAndView mav = new ModelAndView();
        page.setCount(15);
        PageHelper.offsetPage(page.getStart(),15);
        List<LogWithBLOBs> logWithBLOBs = logService.list();
        int total = (int) new PageInfo<>(logWithBLOBs).getTotal();
        page.caculateLast(total);
        mav.addObject("logs",logWithBLOBs);
        mav.setViewName("operation-log");
        return mav;
    }
}
