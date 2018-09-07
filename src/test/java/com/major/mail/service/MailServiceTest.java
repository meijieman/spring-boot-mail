package com.major.mail.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {


    private static final String TO = "jie.mei@lunzn.com";

    @Resource
    private MailService mailService;

    @Resource
    private TemplateEngine templateEngine;

    @Test
    public void sayTest() {
        mailService.say();
    }

    @Test
    public void sendMailTest() {
        mailService.sendMail(TO, "这是第一封邮件主题", "这是第一封邮件内容");
    }

    @Test
    public void sendHtmlMailTest() throws MessagingException {
        String content = "<html><body>" +
                "<h3>hello world, 这是一封 html 邮件</h3>" +
                "</body></html>";
        mailService.sendHtmlMail(TO, "这是html邮件主题", content);
    }

    @Test
    public void sendAttachmentsMailTest() throws MessagingException {
        String content = "<html><body>" +
                "邮件正文" +
                "</body></html>";
        String filePath = "./file/Chat.rar";
        mailService.sendAttachmentsMail(TO, "这是包含附件的邮件主题", content, filePath);
    }

    @Test
    public void sendInlineResourceMailTest() throws MessagingException {
        String imgPath = "./file/404.jpg";
        String rscId = "ha001";
        String content = "<html><body>这是有图片的邮件：" +
                "<img src=\'cid:" + rscId + "\'></img>" +
                "</body></html>";

        mailService.sendInlineResourceMail(TO, "这是一个带有图片的邮件主题", content, imgPath, rscId);
    }

    @Test
    public void testTemplateMailTest() throws MessagingException {
        Context context = new Context();
        context.setVariable("id", "006");

        String emailContet = templateEngine.process("emailTemplate", context);
        mailService.sendHtmlMail(TO, "这是一个模版邮件", emailContet);
    }
}