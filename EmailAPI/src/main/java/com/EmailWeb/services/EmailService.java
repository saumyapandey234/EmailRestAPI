package com.EmailWeb.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {

  // Place @Value here (class-level fields)
  @Value("${mail.username}")
  private String from;

  @Value("${mail.password}")
  private String password;

  public boolean sendEmail(String subject, String message, String to) {
    boolean f = false;

    String host = "smtp.gmail.com";

    Properties properties = new Properties();
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "465");
    properties.put("mail.smtp.ssl.enable", "true");
    properties.put("mail.smtp.auth", "true");

    // ✅ Use the injected fields here
    Session session = Session.getInstance(properties, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(from, password);
      }
    });

    session.setDebug(true);

    try {
      MimeMessage m = new MimeMessage(session);
      m.setFrom(new InternetAddress(from));
      m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
      m.setSubject(subject);
      m.setText(message);

      Transport.send(m);
      System.out.println("✅ Email sent successfully!");
      f = true;

    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("❌ Email sending failed!");
    }

    return f;
  }
}
