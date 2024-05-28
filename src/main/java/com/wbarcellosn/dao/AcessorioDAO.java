package com.wbarcellosn.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.wbarcellosn.entities.Acessorio;

public class AcessorioDAO implements IGenericDAO<Acessorio>{

	@Override
	public Acessorio cadastrar(Acessorio acessorio) {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("ExercicioJpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(acessorio);
		em.getTransaction().commit();
		 
		em.close();
		emf.close();
	
		return acessorio;
	}

}
