package com.wbarcellosn.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.wbarcellosn.entities.Marca;

public class MarcaDAO implements IGenericDAO<Marca>{

	@Override
	public Marca cadastrar(Marca marca) {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("ExercicioJpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(marca);
		em.getTransaction().commit();
		 
		em.close();
		emf.close();
	
		return marca;
	}

}
