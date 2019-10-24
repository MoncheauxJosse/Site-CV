package com.formation.webapp.service;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.formation.webapp.pojo.Mail;
//import fr.ols.webapp.constantes.Constantes;

@Service
public class MailsJava {
	
	Logger logger = LoggerFactory.getLogger(MailsJava.class);


	@Autowired
    private JavaMailSender emailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;
    
    /**
     * Methode qui permet d'envoyer un email Ã  une liste de destinataires
     * @param emails
     * @param sujet
     * @param contenu
     */
    public synchronized void sendEmailContact(Set<String> emails, String sujet, String contenu) {
    	Mail mail = new Mail();
    	Map<String, Object> model = new HashMap<>();
        model.put("message",contenu);
        mail.setModel(model);
        mail.setSubject(sujet);
        String addr = emails.toString();
        addr = addr.replaceAll(", ", ",");
        addr = addr.substring(1, addr.length()-1);
        InternetAddress[] adresses = null;
		try {
			adresses = InternetAddress.parse(addr);
		} catch (AddressException e) {
			logger.error("mailingListError", e);
		}
        
        try {
    		MimeMessage message = emailSender.createMimeMessage();
    		MimeMessageHelper helper = new MimeMessageHelper(message,
    				MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
    				StandardCharsets.UTF_8.name());
    		
    		Context context = new Context();
    		context.setVariables(mail.getModel());
    		String html = templateEngine.process("email/email-template-contact", context);
    		
    		helper.addAttachment("ols.jpg", new ClassPathResource("/static/image/ols.jpg"));
    		helper.setText(html, true);
    		helper.setSubject(mail.getSubject());
    		helper.setFrom(mail.getFrom());

    		helper.setTo(adresses);
    		emailSender.send(message);
    	} catch (Exception e){
    		logger.error("Mailseror", e);
    	}
    }
    
    /**
     * Methode qui permet d'envoyer un email Ã  un destinataire unique et avec le template "email-template-contact.html".
     * @param mail
     */
    public synchronized void sendEmailContact(Mail mail) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            Context context = new Context();
            context.setVariables(mail.getModel());
            String html = templateEngine.process("email/email-template-contact", context);

            //helper.addAttachment("ols.jpg", new ClassPathResource("/static/image/ols.jpg"));
            helper.setTo(mail.getTo());
            helper.setText(html, true);
            helper.setSubject(mail.getSubject());
            helper.setFrom(mail.getFrom());
            emailSender.send(message);
        } catch (Exception e){
    		logger.error("mailserreur", e);
        }
    }
    
    /**
     * Methode qui permet d'envoyer un email Ã  un destinataire unique et avec le template "email-template.html".
     * @param mail
     */
    public synchronized void sendEmail(Mail mail) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            Context context = new Context();
            context.setVariables(mail.getModel());
            String html = templateEngine.process("email/email-template", context);

            helper.setTo(mail.getTo());
            helper.setText(html, true);
            helper.setSubject(mail.getSubject());
            helper.setFrom(mail.getFrom());

            emailSender.send(message);
        } catch (Exception e){
    		logger.error("mailserreurs", e);
        }
    }
    
}