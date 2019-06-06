package com.wyj;

import com.wyj.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * 发送邮件测试类
 *
 * @author wyj
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailApplicationTests {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    /**
     * 测试发送简单邮件
     *
     * @throws Exception
     */
    @Test
    public void simpleMail() throws Exception {
        String to = "wanyingjing@163.com";
        String subject = "简单邮件";
        String content = "测试发送简单邮件";
        mailService.sendSimpleMail(to, subject, content);
    }

    /**
     * 测试发送html邮件
     *
     * @throws Exception
     */
    @Test
    public void htmlMail() throws Exception {
        String to = "wanyingjing@163.com";
        String subject = "html邮件";
        String content = "<html>\n" + "<body>\n" + "    <h1>hello world ! 这是一封html邮件!</h1>\n" + "</body>\n" + "</html>";
        mailService.sendHtmlMail(to, subject, content);
    }

    /**
     * 测试发送带有附件的邮件
     * 添加多个附件可以使用多条 helper.addAttachment(fileName,file)
     *
     * @throws Exception
     */
    @Test
    public void attachmentsMail() throws Exception {
        String to = "wanyingjing@163.com";
        String subject = "带附件的邮件";
        String content = "您有附件，请注意查收！";
        String filePath = "C:\\Users\\EDZ\\Desktop\\application.log";//附件
        mailService.sendAttachmentsMail(to, subject, content, filePath);
    }

    /**
     * 测试发送带静态资源的邮件
     * 添加多个图片可以使用多条 <imgsrc='cid:" + rscId + "'> 和 helper.addInline(rscId,res)来实现
     *
     * @throws Exception
     */
    @Test
    public void staticResourceMail() throws Exception {
        String to = "wanyingjing@163.com";
        String subject = "带图片的邮件";
        String rscId = "neo006";
        String content = "<html><body>详情请看：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\EDZ\\Desktop\\微信截图_20190531102741.png";
        mailService.sendInlineResourceMail(to, subject, content, imgPath, rscId);
    }

    /**
     * 测试发送html模板的邮件
     * 给模板传递参数：context.setVariable("id", "006");
     */
    @Test
    public void templateMail() {
        Context context = new Context();
        String emailContent = templateEngine.process("emailTemplate", context);
        System.out.println(emailContent);
        String to = "wanyingjing@163.com";
        String sbuject = "模板邮件";
        mailService.sendHtmlMail(to, sbuject, emailContent);
    }

}
