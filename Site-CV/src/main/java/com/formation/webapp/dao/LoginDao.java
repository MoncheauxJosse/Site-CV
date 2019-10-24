package com.formation.webapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.webapp.beans.LoginEntity;

@Repository
public interface LoginDao extends JpaRepository<LoginEntity, Long>  {

	public void save(Long id);
}