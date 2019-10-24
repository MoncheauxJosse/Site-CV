package com.formation.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

import com.formation.webapp.beans.LoginEntity;
import com.formation.webapp.pojo.LoginPojo;
import com.formation.webapp.pojo.UtilisateurBean;
import com.formation.webapp.service.ILoginService;
import com.formation.webapp.service.IUtilisateurService;






@Controller
//@RequestMapping("/Login")
public class ControllerClient {
	
	@Autowired
	public IUtilisateurService utilisateurService;
	
	@Autowired
	public ILoginService loginService;
	
	@GetMapping("")
	public String Login () {
		return "Login";
	}
	
	@GetMapping("/Login")
	public String loggin() {
		return "Login";
		
		}
	@PostMapping("/Login")
	public String loggin (LoginPojo client) {
			loginService.ajouterLogin(client);
			return "Accueil";
		}
	@GetMapping("/Client")
public String VoirClient (Model model) {
		
		List<LoginPojo> list = loginService.listeLogin();
		model.addAttribute("listeLogin", list);
		return "Client";
	}
	
	@GetMapping("/Accueil")
	public String Accueil () {
		return "Accueil";
	}
	

	
	@GetMapping("/Profil")
	public String Profil () {
		return "Profil";
	}
	@GetMapping("/AjouterUtilisateur")
	public String AjoutUtilisateur (Model model) {
		
		List<UtilisateurBean> list = utilisateurService.listeUtilisateur();
		model.addAttribute("listeUtilisateur", list);
		return "AjouterUtilisateur";
	}
	
	@PostMapping("/AjouterUtilisateur")
	public String AjouterUtilisateur(UtilisateurBean utilisateur) {
		utilisateurService.ajouterUtilisateur(utilisateur);
		return "redirect:/AjouterUtilisateur";
	}
	
	 @GetMapping("/supprimerUtilisateur/{id}")
	    public String supprimerUtilisateur(@PathVariable Long id) {
	        utilisateurService.deleteById(id);
	        return "redirect:/AjouterUtilisateur";
	    }
	 @GetMapping("/AfficherUtilisateur")
	    public String afficherUtilisateur(Long id, Model model) {
	        model.addAttribute("utilisateur", utilisateurService.recupererUtilisateur(id));
	        return "AfficherUtilisateur";
	    }
		@PostMapping("/modifierUtilisateur")
		public String modifierutilisateur(UtilisateurBean utilisateur) {
			utilisateurService.modifierUtilisateur(utilisateur);
			return "redirect:/AjouterUtilisateur";
		}
	
	
	@GetMapping("/CV")
	public String CV () {
		return "CV";
	}
	
	@GetMapping("/Stage")
	public String Stage () {
		return "Stage";
	}
	
	
	@GetMapping("/MaFormation")
	public String MaFormation () {
		return "MaFormation";
	}
}