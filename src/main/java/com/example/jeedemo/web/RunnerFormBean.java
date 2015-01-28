package com.example.jeedemo.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Runner;
import com.example.jeedemo.service.RunnerManager;
@SessionScoped
@Named("runnerBean")
public class RunnerFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Runner runner = new Runner();
	private ListDataModel<Runner> runners = new ListDataModel<Runner>();
	private ListDataModel<Runner> runnersByName = new ListDataModel<Runner>();
	private Runner runnerToDelete = new Runner();
	private String name;
	@Inject
	private RunnerManager rm;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ListDataModel<Runner> getRunners() {
		return runners;
	}
	public void setRunners(ListDataModel<Runner> runners) {
		this.runners = runners;
	}
	public ListDataModel<Runner> getRunnersByName() {
		return runnersByName;
	}
	public void setRunnersByName(ListDataModel<Runner> runnersByName) {
		this.runnersByName = runnersByName;
	}
	public Runner getRunner(){
		return runner;
	}
	public void setRunner(Runner runner){
		this.runner = runner;
	}
	
	public ListDataModel<Runner> getAllRunners(){
		runners.setWrappedData(rm.getAllRunners());
		return runners;
	}
	public String addRunner(){
		rm.addRunner(runner);
		return "ShowAll";
	}
	
	public String deleteRunner(){
		runnerToDelete = runners.getRowData();
		rm.deleteRunnner(runnerToDelete);
		return null;
		
	}
	public String getRunnerByName(){
		runnersByName.setWrappedData(rm.getRunnersByName(name));
		return null;
	}
	public String saveAction() {
		 
		for (Runner runner : runners){
			runner.setEditable(false);
		}
		
		return null;
	}
	public String editAction() {
		Runner toEdit = runners.getRowData();
		toEdit.setEditable(true);
		return null;
	}

}
