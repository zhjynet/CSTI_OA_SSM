package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhangjingyu
 */
@Controller
@RequestMapping("")
public class TrainingPlanController {

    @RequestMapping("uploadPlan")
    public ModelAndView uploadPlan(){
        return new ModelAndView("upload-plan");
    }

    @RequestMapping("showPlan")
    public ModelAndView showPlan(){
        return new ModelAndView("show-plan");
    }

}
