package com.accolite.aumanagement.model;

public class Demand {
	
	int demand_id;
	String skill;
	
	public Demand() {
		super();
	}
	public Demand(int demand_id, String skill) {
		super();
		this.demand_id = demand_id;
		this.skill = skill;
	}
	public int getDemand_id() {
		return demand_id;
	}
	public void setDemand_id(int demand_id) {
		this.demand_id = demand_id;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	

}
