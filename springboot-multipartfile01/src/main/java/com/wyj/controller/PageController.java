package com.wyj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/singleFileUpload.html")
    public String singleFileUpload() {
        return "singleFileUpload";
    }

    @RequestMapping("/multipleFilesUpload.html")
    public String multipleFilesUpload() {
        return "multipleFilesUpload";
    }

    @RequestMapping("/base64Upload.html")
    public String base64Upload() {
        return "base64Upload";
    }

}
