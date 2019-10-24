package com.formation.webapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.formation.webapp.pojo.Mail;
import com.formation.webapp.service.MailsJava;

@Controller
public class ControllerMail implements Runnable {

	@Autowired
	public MailsJava emailSender;
	
	Mail mail;
	
	@GetMapping("/Mail")
	public String Mail () {
		return "Mail";
	}
	/**
	 * Methode qui controle l'envoie d'un email
	 * @param message
	 * @param id
	 * @param email
	 * @param subject
	 * @return la page HTML affichant la liste des Adherents actifs.
	 */
	//bombe.alicia26@gmail.com
	@PostMapping("/EnvoyerMail")
	public String Email(String message, String subject) {
		Mail couriel = new Mail();
		String email = "lordssly@gmail.com";
        couriel.setTo(email);
        couriel.setSubject(subject);
        Map<String, Object> model = new HashMap<>();
        model.put("message",message);
        couriel.setModel(model);
        this.mail = couriel;
    	Thread t = new Thread(this);
    	t.start();
		
		return "Mail";
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		emailSender.sendEmailContact(this.mail);
	}
}
