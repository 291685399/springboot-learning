package com.wyj.controller;

import com.wyj.entity.vo.ApiResponse;
import com.wyj.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AjaxErrorController {

    @RequestMapping("/ajaxerror")
    public ModelAndView ajaxerror() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ajaxerror");
        return modelAndView;
    }

    @RequestMapping("/getException")
    @ResponseBody
    public ApiResponse getAjaxerror() {
        int a = 1 / 0;
        return ApiResponse.ok();
    }

    @RequestMapping("/getMyException")
    @ResponseBody
    public ApiResponse getMyException() throws MyException {
        String str = null;
        if (str == null) {
            throw new MyException();
        }
        return ApiResponse.ok();
    }

}
