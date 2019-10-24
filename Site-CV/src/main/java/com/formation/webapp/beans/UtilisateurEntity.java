package com.formation.webapp.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.formation.webapp.pojo.UtilisateurBean;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class UtilisateurEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "utilisateur_generator")
	@SequenceGenerator(name = "utilisateur_generator", sequenceName = "utilisateur_sequence", initialValue = 3, allocationSize = 1)
	private Long id;
	private String Role;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	@Valid
	private String adresse;
	private String telephone;
	@Email
	private String mail;

	
	public UtilisateurEntity() {
		super();
	}

	public UtilisateurEntity(UtilisateurBean e) {
		super();
		this.id = e.getId();
		this.Role = e.getRole();
		this.nom = e.getNom();
		this.prenom = e.getPrenom();
		this.dateNaissance = e.getDateNaissance();
		this.adresse = e.getAdresse();
		this.telephone = e.getTelephone();
		this.mail = e.getMail();
	}

	public UtilisateurBean convertToEntity(UtilisateurEntity eb) {
		UtilisateurBean conv = new UtilisateurBean();
		conv.setId(eb.getId());
		conv.setNom(eb.getNom());
		conv.setPrenom(eb.getPrenom());
		conv.setDateNaissance(eb.getDateNaissance());
		conv.setAdresse(eb.getAdresse());
		conv.setTelephone(eb.getTelephone());
		conv.setMail(eb.getMail());
		conv.setRole(eb.getRole());
		
		return conv;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String Role) {
		this.Role= Role;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static List<UtilisateurEntity> toArray(List<UtilisateurBean> utilisateurs) {
		List<UtilisateurEntity> resultat = new ArrayList<>();
		for (UtilisateurBean utilisateur : utilisateurs) {
			resultat.add(new UtilisateurEntity(utilisateur));
		}
		return resultat;
	}



}
