package com.lohith.data.Employee;



public class Employee {  //public method
	private String fnme;
	private String lname;
	private String empid;
	private String email;
	
	public Employee(){ //public method
		
	}
	public Employee(String fnme, String lname, String empid, String email) {           //public method
		super();
		this.fnme = fnme;
		this.lname = lname;
		this.empid = empid;
		this.email = email;
	}
	public String getFnme() {              //public method
		return fnme;
	}
	public void setFnme(String fnme) {               //public method
		this.fnme = fnme;
	}
	public String getLname() {               //public method
		return lname;
	}
	public void setLname(String lname) {                  //public method
		this.lname = lname;
	}
	public String getEmpid() {                 //public method
		return empid;
	}
	public void setEmpid(String empid) {                 //public method
		this.empid = empid;
	}
	public String getEmail() {                   //public method
		return email;
	}
	public void setEmail(String email) {                //public method
		this.email = email;
	}
	
	
	@Override
	public String toString()
	{
	return "Employee [fnme=" + fnme + ",lname" + lname + ",empid" + empid + ",email" + email + "]";
	}
	

}

