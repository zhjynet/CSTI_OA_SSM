package com.controller;

import com.pojo.LogWithBLOBs;
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
    public ModelAndView operationLog(){
        ModelAndView mav = new ModelAndView();
        List<LogWithBLOBs> logWithBLOBs = logService.list();
        mav.addObject("logs",logWithBLOBs);
        mav.setViewName("operation-log");
        return mav;
    }
}
