package com.necl.service;

import com.necl.model.Mail;
import java.util.HashMap;
import java.util.Map;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.velocity.VelocityEngineUtils;

@Service("mailService")
@Transactional
public class SendMailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private UserService userService;

    @Autowired
    private ConfigSystemService configSystemService;


    private void sendEmail(final Mail mail) throws Exception {

        // reads form input
        final String emailTo = mail.getMailTo(); // คนที่มีสิทธิ์ approve

        final InternetAddress[] iAdressArray = InternetAddress.parse(emailTo);

        mailSender.send(new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(
                        mimeMessage, true, "UTF-8");
                messageHelper.setTo(iAdressArray);
                messageHelper.setSubject(mail.getMailSubject());
                messageHelper.setText(mail.getMailMessage(), true);
                messageHelper.setFrom(mail.getMailFrom());
            }

        });
    }

      
    
    ////////////////////////////////// Test /////////////////////////////////////////
    
    
//     public void sendEmailRequest(JobCalendar jobCalendar) {
//        try {
//            Mail mail = new Mail();
//
//            String emailTo = "P.Samart@nipponexpress-necl.co.th";
//            System.out.println("emailTo: " + emailTo);
//            Map<String, Object> modelMap = new HashMap<>();
//            String message;
//
//            //set variable show in vm file
//            modelMap.put("no", jobCalendar.getJobNo());
//            modelMap.put("job", jobCalendar.getBaseJobRequest());
//            modelMap.put("title", jobCalendar.getTitle());
//            modelMap.put("description", jobCalendar.getDescription());
//            modelMap.put("requestBy", jobCalendar.getCreateBy());
//            modelMap.put("telephone", jobCalendar.getTelephone());
//
//            //set detail Mail Object
//            mail.setMailFrom(mail.getMailFrom());
//            mail.setMailTo(emailTo);
//            mail.setMailSubject("New request for IT-Tracking. ( " + jobCalendar.getCreateBy() + " - " + jobCalendar.getJobNo() + " )");
//            mail.setTemplateName("/mail/request.vm");
//
//            //set body message
//            message = VelocityEngineUtils.mergeTemplateIntoString(
//                    velocityEngine, mail.getTemplateName(), "UTF-8", modelMap);
//
//            mail.setMailMessage(message);
//
//            sendEmail(mail);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

  
    

}
