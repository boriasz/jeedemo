package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Runner;

@Stateless
public class RunnerManager {
	
	@PersistenceContext
	EntityManager em;
	
	public void addRunner(Runner runner){
		runner.setId(null);
		em.persist(runner);
		
	}
	
	public void deleteRunnner(Runner runner){
		runner = em.find(Runner.class, runner.getId());
		em.remove(runner);
	}
	
	@SuppressWarnings("unchecked")
	public List<Runner> getAllRunners(){
		return em.createNamedQuery("runner.all").getResultList();
		
	}
	@SuppressWarnings("unchecked")
	public List<Runner> getRunnersByName(String name){
		return em.createNamedQuery("runner.ByName").setParameter("firstName", name).getResultList();
	}
	public void updateRunner(Runner runner){
		
		
		
		
		runner.setId(runner.getId());
		runner.setFirstName(runner.getFirstName());
		runner.setLastName(runner.getLastName());
		runner.setNationality(runner.getNationality());
		runner.setDateOfBirth(runner.getDateOfBirth());
		runner.setBestDistance(runner.getBestDistance());
		runner.setWeight(runner.getWeight());
		runner.setHeight(runner.getHeight());
		runner.setGender(runner.getGender());
		
		em.merge(runner);
		
	}
	

}
