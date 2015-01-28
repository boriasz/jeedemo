package com.example.jeedemo.domain;

import java.util.Date;

import javax.management.Query;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "runner.all", query = "Select r from Runner r"),
	@NamedQuery(name = "runner.ByName", query = "Select r from Runner r WHERE r.firstName = :firstName")
})
@Table(name="Runner")
public class Runner {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String nationality;
	@Past
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	private double bestDistance;
	private int weight;
	@Min(100)
	private int height;
	private String gender;	
	private boolean editable;
	
	
	public Runner() {
		super();
	}
	public Long getId() {
		return id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public double getBestDistance() {
		return bestDistance;
	}
	public void setBestDistance(double bestDistance) {
		this.bestDistance = bestDistance;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	
	
}
