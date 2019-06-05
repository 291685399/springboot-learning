package com.wyj.handler;

import com.wyj.entity.vo.ApiResponse;
import com.wyj.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理类
 */
@ControllerAdvice
public class WebAjaxExceptionHandler {

    @ExceptionHandler(value = MyException.class)
    public Object myExceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        e.printStackTrace();
        //判断请求是否为Ajax请求
        if (isAjax(request)) { //如果是的话，就直接返回错误信息
            return ApiResponse.errorException(e.getMessage());
        } else { //如果不是的话，就跳转到错误页面
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("exception", e);
            modelAndView.addObject("msg", "抛出自定义异常");
            modelAndView.setViewName("error");
            return modelAndView;
        }
    }

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        e.printStackTrace();
        if (isAjax(request)) {
            return ApiResponse.errorException(e.getMessage());
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("exception", e);
            modelAndView.addObject("msg", "抛出异常");
            modelAndView.setViewName("error");
            return modelAndView;
        }
    }

    /**
     * 判断是否是Ajax请求
     *
     * @param request
     * @return
     */
    public boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null &&
                "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }

}