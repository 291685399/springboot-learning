package com.wyj.service;

public interface MailService {

    /**
     * 发送简单邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    public void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送HTML邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    public void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送带有附件的邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param filePath
     */
    public void sendAttachmentsMail(String to, String subject, String content, String filePath);

    /**
     * 发送带静态资源的邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param rscPath
     * @param rscId
     */
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);

}
