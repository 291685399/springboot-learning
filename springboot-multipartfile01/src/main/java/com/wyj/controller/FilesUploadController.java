package com.wyj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class FilesUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FilesUploadController.class);

    /**
     * 单文件上传
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/singleFileUpload")
    @ResponseBody
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "请选择文件";
        }
        String fileName = file.getOriginalFilename();
        String filePath = "C:/Users/EDZ/Desktop/temp/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            logger.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("上传失败");
            return "上传失败";
        }
    }

    /**
     * 多文件上传
     *
     * @param request
     * @return
     */
    @RequestMapping("/multipleFilesUpload")
    @ResponseBody
    public String multipleFilesUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        if (files.isEmpty() || files.size() == 0) {
            return "请选择文件";
        }
        String filePath = "C:/Users/EDZ/Desktop/temp/";
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty() || file.getName().isEmpty()) {
                logger.info("上传第" + (++i) + "个文件失败");
                return "上传第" + (++i) + "个文件失败";
            }
            String fileName = file.getOriginalFilename();
            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                logger.info("第" + (i + 1) + "个文件上传成功");
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("上传第" + (++i) + "个文件失败");
                return "上传第" + (++i) + "个文件失败";
            }
        }
        return "上传成功";
    }

    /**
     * base64编码上传
     *
     * @param request
     * @throws IOException
     */
    @PostMapping("/base64Upload")
    @ResponseBody
    public String base64Upload(HttpServletRequest request) throws IOException {
        try {
            String base64Phone = request.getParameter("base64Phone");
            if (base64Phone == null || "".equals(base64Phone)) {
                return "请选择文件";
            }
            final File tempFile = new File("C:/Users/EDZ/Desktop/temp/test.jpg");
            String[] base64Body = base64Phone.split("base64,");
            logger.info(base64Phone);
            byte[] bytes = Base64Utils.decodeFromString(base64Body.length > 1 ? base64Body[1] : base64Body[0]);
            FileCopyUtils.copy(bytes, tempFile);
            logger.info("上传成功");
            return "上传成功";
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("上传失败");
            return "上传失败";
        }
    }
}
