package sample;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.*;
import javax.mail.*;
import javax.activation.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Sending_the_email {
    //Sending the actual Email
    static void send(String recipient, String body, String subject, String username, String password){
        String to = recipient;
        String text = body;
        String subject_of_email = subject;
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");



        Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username, password);
            }
        });

        session.setDebug(true);

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject_of_email);
            message.setText(text);
            Transport.send(message);
            System.out.println("The message is being sent");


        } catch (MessagingException mex){
            mex.printStackTrace();
        }
    }

}
