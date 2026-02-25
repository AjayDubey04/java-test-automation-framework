package com.vtigercrm.runners;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.util.Properties;

public class EmailSender {

    
    
    public static void sendReportByEmail() {
        final String username = "createajay229@gmail.com"; // Your Gmail email address
        final String password = "dubeyji63"; // Your Gmail password

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Step 1: Create the email content using Thymeleaf
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(createEmailContent(), "text/html");

            // Step 2: Create the attachment
            File pdfAttachment = new File("target/cucumber-reports/index.html");
            DataSource source = new FileDataSource(pdfAttachment);
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            attachmentBodyPart.setDataHandler(new DataHandler(source));
            attachmentBodyPart.setFileName(pdfAttachment.getName());

            // Step 3: Create the Multipart object and add parts to it
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentBodyPart);

            // Step 4: Create and send the email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("testlead@example.com"));
            message.setSubject("Cucumber Report");
            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static String createEmailContent() {
        // Use Thymeleaf to create the email content
        TemplateEngine templateEngine = new TemplateEngine();
        Context context = new Context();
        // Add any additional information you want to include in the email content
        context.setVariable("greeting", "Hello,");
        context.setVariable("message", "Please find the Cucumber report attached.");

        return templateEngine.process("email-template.html", context);
    }
}
    
   
