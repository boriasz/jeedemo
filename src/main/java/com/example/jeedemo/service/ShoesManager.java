package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Runner;
import com.example.jeedemo.domain.Shoes;

@Stateless
public class ShoesManager {
	@PersistenceContext
	EntityManager em;
	
	public void addShoes(Shoes shoes, Long runnerID){
		List<Shoes> shoesList = new ArrayList<Shoes>();
		shoesList.add(shoes);
		Runner runner = new Runner();
		runner = em.find(Runner.class, runnerID);
		shoes.setId(null);
		shoes.setRunner(runner);
		em.persist(shoes);
	}
	public void deleteShoes(Shoes shoes){
		shoes = em.find(Shoes.class, shoes.getId());
		em.remove(shoes);
	}
	@SuppressWarnings("unchecked")
	public List<Shoes> getAllShoes(){
		return em.createNamedQuery("shoes.all").getResultList();
	}
	
}
