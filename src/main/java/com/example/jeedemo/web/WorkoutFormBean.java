package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Workout;
import com.example.jeedemo.service.WorkoutManager;

@SessionScoped
@Named("workoutBean")
public class WorkoutFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Workout workout = new Workout();
	private ListDataModel<Workout> workouts = new ListDataModel<Workout>();
	private Workout workoutToDelete = new Workout();
	private Long runnerID;
	@Inject
	WorkoutManager wm;
	
	public Long getRunnerID() {
		return runnerID;
	}
	public void setRunnerID(Long runnerID) {
		this.runnerID = runnerID;
	}
	public Workout getWorkout(){
		return workout;
	}
	public void setWorkout(Workout workout){
		this.workout = workout;
	}
	
	public ListDataModel<Workout> getAllWorkouts(){
		workouts.setWrappedData(wm.getAllWorkouts());
		return workouts;
	}
	public String addWorkout(){
		wm.addWorkout(workout,runnerID);
		return "showAllWorkouts";
	}
	public String deleteWorkout(){
		workoutToDelete = workouts.getRowData();
		wm.deleteWorkout(workoutToDelete);
		return "showAllWorkouts";
	}
	public String saveAction(){
		for(Workout workout : workouts){
			workout.setEditable(false);
		}
		return null;
	}
	public String editAction(){
		Workout toEdit = workouts.getRowData();
		toEdit.setEditable(true);
		return null;
	}
	
	 
	

}
