package com.lohith.data.Employee.projectmanager;

import java.sql.Connection;
import java.util.ArrayList;

import com.lohith.data.Employee.Employee;
import com.lohith.data.Employee.database.Database;
import com.lohith.data.Employee.project.Project;


public class ProjectManager {

	public ArrayList<com.lohith.data.Employee.Employee> GetEmp() throws Exception {
		ArrayList<Employee> emp = null;
			com.lohith.data.Employee.database.Database database = new com.lohith.data.Employee.database.Database();
			Connection connection = database.Get_Connection();
			com.lohith.data.Employee.project.Project project = new com.lohith.data.Employee.project.Project();
			emp = project.GetEmployee(connection);
			connection.close();
		return emp;
	}

	public String addemployee(String fname,String lname,final String empid,String email) throws Exception {
		String emp=null;
		try {
			
			Database database = new Database();
			Connection connection = database.Get_Connection();
			Project project = new Project();
			emp = project.addemp(connection,fname,lname,empid,email);
			connection.close();
		} catch (Exception e) {
			throw e;
		}
		return emp;
	}
	
	public String Deleteemployee(String str) throws Exception {
		String res=null;
		//try {
			Database database = new Database();
			Connection connection = database.Get_Connection();
			Project project = new Project();
			 res = project.deleemp(connection,str);
			 connection.close();
		//} catch (Exception e) {
			//throw e;
		//}
		return res;
		
	}

	public ArrayList<Employee> GetSingleEmp(String st) throws Exception {
		ArrayList<Employee> emp = null;
		//try {
			Database database = new Database();
			Connection connection = database.Get_Connection();
			Project project = new Project();
			emp = project.SingleEmployee(connection, st);
			connection.close();
		//} catch (Exception e) {
		//	throw e;
		//}
		return emp;
	}

	public ArrayList<Employee> updateEmp(String id,String fname,String lname,String email) throws Exception {
		ArrayList<Employee> emp = null;
		try {
			Database database = new Database();
			Connection connection = database.Get_Connection();
			Project project = new Project();
			emp = project.updateEmployee(connection,id,fname,lname,email);
			connection.close();
		} catch (Exception e) {
			throw e;
		}
		return emp;
	}
	
	
	
}
