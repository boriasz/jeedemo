package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Runner;
import com.example.jeedemo.domain.Workout;

@Stateless
public class WorkoutManager {
	@PersistenceContext
	EntityManager em;
	
	public void addWorkout(Workout workout, Long runnerID){
		List<Workout> workouts = new ArrayList<Workout>();
		workouts.add(workout);
		Runner runner = new Runner();
		runner = em.find(Runner.class, runnerID);
		workout.setRunner(runner);
		workout.setId(null);
		em.persist(workout);
	}
	public void deleteWorkout(Workout workout){
		em.find(Workout.class, workout.getId());
	}
	@SuppressWarnings("unchecked")
	public List<Workout> getAllWorkouts(){
		return em.createNamedQuery("workout.all").getResultList();
	}
}
