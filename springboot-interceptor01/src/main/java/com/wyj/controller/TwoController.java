package com.wyj.controller;

import com.wyj.entity.vo.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wyj
 * @create 2019-06-01 22:10
 */
@Controller
@RequestMapping(value = "/two")
public class TwoController {

    @RequestMapping(value = "/index")
    @ResponseBody
    public ApiResponse index() {
        return new ApiResponse("two");
    }

}
