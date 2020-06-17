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
	String skill_1;
	String skill_2;
	String skill_3;
	boolean status;
	int experience;
	long phone_number;
	String current_address;
	int C_pincode;
	boolean BGC;
	String designation;
	int demand_id;
	long bank_ac_no;
	String ifsc_code;
	String name;
	String branch;
	
	
	public Employee() {
		super();
		
	}
		
	public Employee(int id, String first_name) {
		super();
		this.id = id;
		this.first_name = first_name;
	}
	
	public Employee(int id, String first_name ,String email,String pan_number) {
		super();
		this.id = id;
		this.email = email;
		this.version = 0;
		this.first_name = first_name;
		this.last_name = "Ram";
		this.dob = new Date(12-03-1999);
		this.blood_type = "O+ve";
		this.gender = "Male";
		this.date_of_joining = new Date(06-05-2020);
		this.permanent_address = "Permanent Address";
		P_pincode = 12345;
		this.pan_number = pan_number;
		this.skill_1 = "Angular";
		this.skill_2 = "Java";
		this.skill_3 = "Python";
		this.status = true;
		this.experience = 3;
		this.phone_number = (658267373);
		this.current_address = "Current Address";
		C_pincode = 67890;
		BGC = true;
		this.designation = "SDE";
		this.demand_id = 5;
		this.bank_ac_no = 1234567;
		this.ifsc_code = "PNB201719";
		this.name = first_name;
		this.branch = "PNB Branch";
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
	public int getDemand_id() {
		return demand_id;
	}
	public void setDemand_id(int demand_id) {
		this.demand_id = demand_id;
	}
	public String getSkill_1() {
		return skill_1;
	}
	public void setSkill_1(String skill_1) {
		this.skill_1 = skill_1;
	}
	public String getSkill_2() {
		return skill_2;
	}
	public void setSkill_2(String skill_2) {
		this.skill_2 = skill_2;
	}
	public String getSkill_3() {
		return skill_3;
	}
	public void setSkill_3(String skill_3) {
		this.skill_3 = skill_3;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getIfsc_code() {
		return ifsc_code;
	}
	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ", version=" + version + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", dob=" + dob + ", blood_type=" + blood_type + ", gender=" + gender
				+ ", date_of_joining=" + date_of_joining + ", permanent_address=" + permanent_address + ", P_pincode="
				+ P_pincode + ", pan_number=" + pan_number + ", skill_1=" + skill_1 + ", skill_2=" + skill_2
				+ ", skill_3=" + skill_3 + ", status=" + status + ", experience=" + experience + ", phone_number="
				+ phone_number + ", current_address=" + current_address + ", C_pincode=" + C_pincode + ", BGC=" + BGC
				+ ", designation=" + designation + ", demand_id=" + demand_id + ", bank_ac_no=" + bank_ac_no
				+ ", ifsc_code=" + ifsc_code + ", name=" + name + ", branch=" + branch + "]";
	}

	
}
