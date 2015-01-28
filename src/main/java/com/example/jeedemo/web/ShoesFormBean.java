package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Shoes;
import com.example.jeedemo.service.ShoesManager;

@SessionScoped
@Named("shoesBean")
public class ShoesFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Shoes shoes = new Shoes();
	private ListDataModel<Shoes> shoesList = new ListDataModel<Shoes>();
	private Shoes shoesToDelete = new Shoes();
	private Long runnerID;
	
	@Inject
	ShoesManager sm;
	
	public Shoes getShoes(){
		return shoes;
	}
	public void setShoes(Shoes shoes){
		this.shoes = shoes;
	}
	public Long getRunnerID(){
		return runnerID;
	}
	public void setRunnerID(Long runnerID){
		this.runnerID = runnerID;
	}
	public ListDataModel<Shoes> getAllShoes(){
		shoesList.setWrappedData(sm.getAllShoes());
		return shoesList;
	}
	public String addShoes(){
		sm.addShoes(shoes,runnerID);
		return "ShowAllShoes";
	}
	public String deleteShoes(){
		shoesToDelete = shoesList.getRowData();
		sm.deleteShoes(shoesToDelete);
		return "ShowAllShoes";
	}
	public String saveAction(){
		for(Shoes shoes : shoesList){
			shoes.setEditable(false);
			
		}
		return null;
	}
	public String editAction(){
		Shoes toEdit = shoesList.getRowData();
		toEdit.setEditable(true);
		return null;
	}
	

}
