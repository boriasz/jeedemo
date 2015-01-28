package com.example.jeedemo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "shoes.all", query = "Select s from Shoes s")
})
@Table(name="Shoes")
public class Shoes {
	@Id
	@GeneratedValue
	private Long id;
	private String brand;
	private String model;
	private String footType;
	private int price;
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private Runner runner;
	private boolean editable;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getFootType() {
		return footType;
	}
	public void setFootType(String footType) {
		this.footType = footType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public Runner getRunner() {
		return runner;
	}
	public void setRunner(Runner runner) {
		this.runner = runner;
	}
	
	
	

}
