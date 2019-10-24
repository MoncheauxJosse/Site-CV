package com.formation.webapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.formation.webapp.beans.UtilisateurEntity;

@Repository
public interface UtilisateurDao extends JpaRepository<UtilisateurEntity, Long>  {


	public void save(Long id);

//	public Adherent rechecherAdherentParNom(String string);

}
