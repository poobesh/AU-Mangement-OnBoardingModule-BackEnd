package com.accolite.aumanagement.model;

import java.sql.Date;

public class Employee {
	int id;
	String email;
	int version;
	String first_name;
	String last_name;
	Date dob;
	String blood_type;
	String gender;
	Date date_of_joining;
	String permanent_address;
	int P_pincode;
	String pan_number;
	int skill_id;
	int experience;
	long phone_number;
	String current_address;
	int C_pincode;
	boolean BGC;
	String designation;
	long bank_ac_no;
	String demand_id;
	
	public Employee() {
		super();
		
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String i) {
		this.first_name = i;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getBlood_type() {
		return blood_type;
	}
	public void setBlood_type(String blood_type) {
		this.blood_type = blood_type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDate_of_joining() {
		return date_of_joining;
	}
	public void setDate_of_joining(Date date_of_joining) {
		this.date_of_joining = date_of_joining;
	}
	public String getPermanent_address() {
		return permanent_address;
	}
	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}
	public int getP_pincode() {
		return P_pincode;
	}
	public void setP_pincode(int p_pincode) {
		P_pincode = p_pincode;
	}
	public String getPan_number() {
		return pan_number;
	}
	public void setPan_number(String pan_number) {
		this.pan_number = pan_number;
	}
	public int getSkill_id() {
		return skill_id;
	}
	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	public String getCurrent_address() {
		return current_address;
	}
	public void setCurrent_address(String current_address) {
		this.current_address = current_address;
	}
	public int getC_pincode() {
		return C_pincode;
	}
	public void setC_pincode(int c_pincode) {
		C_pincode = c_pincode;
	}
	public boolean getBGC() {
		return BGC;
	}
	public void setBGC(boolean bGC) {
		BGC = bGC;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public long getBank_ac_no() {
		return bank_ac_no;
	}
	public void setBank_ac_no(long bank_ac_no) {
		this.bank_ac_no = bank_ac_no;
	}
	public String getDemand_id() {
		return demand_id;
	}
	public void setDemand_id(String demand_id) {
		this.demand_id = demand_id;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ", version=" + version + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", dob=" + dob + ", blood_type=" + blood_type + ", gender=" + gender
				+ ", date_of_joining=" + date_of_joining + ", permanent_address=" + permanent_address + ", P_pincode="
				+ P_pincode + ", pan_number=" + pan_number + ", skill_id=" + skill_id + ", experience=" + experience
				+ ", phone_number=" + phone_number + ", current_address=" + current_address + ", C_pincode=" + C_pincode
				+ ", BGC=" + BGC + ", designation=" + designation + ", bank_ac_no=" + bank_ac_no + ", demand_id="
				+ demand_id + "]";
	}
	
	

}
