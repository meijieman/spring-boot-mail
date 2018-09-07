package com.major.mail.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {


    @Resource
    private MailService mailService;

    @Test
    public void sayTest() {
        mailService.say();
    }

    @Test
    public void sendMailTest() {
        mailService.sendMail("jie.mei@lunzn.com", "这是第一封邮件主题", "这是第一封邮件内容");
    }

}