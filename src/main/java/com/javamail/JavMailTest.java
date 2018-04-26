package com.javamail;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * 发送邮件
 */
public class JavMailTest {

    public static void main(String[] args) throws Exception {
        //1. 创建一封邮件
        //  用于连接邮件服务器的参数配置（发送邮件时才需要用到）
        Properties pros = new Properties();
        // 根据参数配置，创建会话对象（为了发送邮件准备的）
        Session session = Session.getInstance(pros);
        // 创建邮件对象
        MimeMessage message = new MimeMessage(session);
        // 2. From: 发件人
        // 其中 InternetAddress 的三个参数分别为: 邮箱,
        // 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
        //    真正要发送时, 邮箱必须是真实有效的邮箱。
        message.setFrom(new InternetAddress("921757697@qq.com", "alison", "UTF-8"));
        // 3. To: 收件人
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("m18045171470@163.com", "alison1", "UTF-8"));
        //  To: 增加收件人（可选）
//        message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress("dd@.com", "USER_DD", "UTF-8"));
        //    Cc: 抄送（可选）
//        message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("ee@receive.com", "USER_EE", "UTF-8"));
        //    Bcc: 密送（可选）
//        message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("ff@receive.com", "USER_FF", "UTF-8"));
        // 4. Subject: 邮件主题
        message.setSubject("TEST邮件主题", "UTF-8");
        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent("TEST这是邮件正文。。。", "text/html;charset=UTF-8");
        // 6. 设置显示的发件时间
        message.setSentDate(new java.util.Date());
        // 7. 保存前面的设置
        message.saveChanges();
        // 8. 将该邮件保存到本地
        OutputStream out = new FileOutputStream("MyEmail.eml");
        message.writeTo(out);
        out.flush();
        out.close();

    }
}
