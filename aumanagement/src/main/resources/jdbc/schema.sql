DROP TABLE IF EXISTS  bank_details;
CREATE TABLE bank_details (
  ac_no bigint(20) NOT NULL,
  ifsc_code varchar(10) NOT NULL,
  name varchar(30) NOT NULL,
  branch varchar(30) NOT NULL
)  ;

DROP TABLE IF EXISTS  trends;
CREATE TABLE trends (
  company_name varchar(30) NOT NULL,
  count int(11) NOT NULL,
  year int(11) NOT NULL
)  ;

DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
id int(11)
,email varchar(50)
,version int(11)
,first_name varchar(15)
,last_name varchar(15)
,dob date
,blood_type varchar(5)
,gender varchar(6)
,date_of_joining date
,permanent_address text
,permanent_pincode int(11)
,pan_number varchar(10)
,skill_1 varchar(30)
,skill_2 varchar(30)
,skill_3 varchar(30)
,status tinyint(1) 							
,experience int(11)
,phone_number bigint(11)
,current_address text
,current_pincode int(11)
,BGC tinyint(1)
,designation varchar(20)
,demand_id int(11)
,ac_no bigint(20)
,ifsc_code varchar(10)
,name varchar(30)
,branch varchar(30)
);

DROP TABLE IF EXISTS employee_constant;
CREATE TABLE employee_constant (
  id int(11) NOT NULL,
  first_name varchar(15) NOT NULL,
  last_name varchar(15) NOT NULL,
  email varchar(50) NOT NULL,
  dob date NOT NULL,
  blood_type varchar(5) NOT NULL,
  gender varchar(6) NOT NULL,
  date_of_joining date NOT NULL,
  permanent_address text NOT NULL,
  pincode int(11) NOT NULL,
  pan_number varchar(10) NOT NULL,
  version int(11) NOT NULL DEFAULT '0',
  status tinyint(1) NOT NULL DEFAULT '1'
)  ;

DROP TABLE IF EXISTS employee_editable;
CREATE TABLE employee_editable (
  emailversion varchar(50) NOT NULL,
  experience int(11) NOT NULL,
  phone_number bigint(11) NOT NULL,
  current_address text NOT NULL,
  pincode int(11) NOT NULL,
  BGC tinyint(1) NOT NULL,
  designation varchar(20) NOT NULL,
  bank_ac_no bigint(20) NOT NULL,
  demand_id int(11) DEFAULT NULL
)  ;

DROP TABLE IF EXISTS employee_skill;
CREATE TABLE employee_skill (
id int(11)
,email varchar(50)
,version int(11)
,first_name varchar(15)
,last_name varchar(15)
,dob date
,blood_type varchar(5)
,gender varchar(6)
,date_of_joining date
,permanent_address text
,permanent_pincode int(11)
,pan_number varchar(10)
,skill_1 varchar(30)
,skill_2 varchar(30)
,skill_3 varchar(30)
,status tinyint(1)
,experience int(11)
,phone_number bigint(11)
,current_address text
,current_pincode int(11)
,BGC tinyint(1)
,designation varchar(20)
,demand_id int(11)
,bank_ac_no bigint(20)
);



DROP TABLE IF EXISTS employee_temporary;
CREATE TABLE employee_temporary (
id int(11)
,first_name varchar(15)
,last_name varchar(15)
,email varchar(50)
,dob date
,blood_type varchar(5)
,gender varchar(6)
,date_of_joining date
,permanent_address text
,permanent_pincode int(11)
,pan_number varchar(10)
,version int(11)
,status tinyint(1)
,emailversion varchar(50)
,experience int(11)
,phone_number bigint(11)
,current_address text
,current_pincode int(11)
,BGC tinyint(1)
,designation varchar(20)
,bank_ac_no bigint(20)
,demand_id int(11)
);


DROP TABLE IF EXISTS skill;
CREATE TABLE skill (
  pan_number varchar(10) NOT NULL,
  skill_1 varchar(30) NOT NULL,
  skill_2 varchar(30) NOT NULL,
  skill_3 varchar(30) NOT NULL
) ;

DROP TABLE IF EXISTS demand;
CREATE TABLE demand (
  demand_id int(11) NOT NULL,
  hiring_manager_id int(11) NOT NULL,
  company_name varchar(30) NOT NULL,
  location varchar(15) NOT NULL,
  skillset varchar(30) NOT NULL,
  joining_date date NOT NULL,
  status varchar(6) NOT NULL,
  posted_date date NOT NULL
);



ALTER TABLE bank_details
  ADD PRIMARY KEY (ac_no);





ALTER TABLE employee_constant
  ADD PRIMARY KEY (id);


ALTER TABLE employee_editable
  ADD PRIMARY KEY (emailversion);



ALTER TABLE skill
  ADD PRIMARY KEY (pan_number);

