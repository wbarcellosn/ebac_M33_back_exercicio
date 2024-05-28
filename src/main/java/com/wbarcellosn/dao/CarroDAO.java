package com.wbarcellosn.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.wbarcellosn.entities.Carro;

public class CarroDAO implements IGenericDAO<Carro>{

	@Override
	public Carro cadastrar(Carro carro) {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("ExercicioJpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(carro);
		em.getTransaction().commit();
		 
		em.close();
		emf.close();
	
		return carro;
	}

}
