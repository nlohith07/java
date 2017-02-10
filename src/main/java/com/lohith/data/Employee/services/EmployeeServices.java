package com.lohith.data.Employee.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.lohith.data.Employee.Employee;
import com.lohith.data.Employee.database.Database;
import com.lohith.data.Employee.project.Project;
import com.lohith.data.Employee.projectmanager.ProjectManager;

@Path("/employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeServices {
	String emp = null;
	Connection con = null;
	ResultSet rs = null;

	@GET
	public String employee() {
		int n = 0;
		String emp = null;
		try {
			ArrayList<Employee> employee = null;
			ProjectManager projectManager = new ProjectManager();
			Database dbconn = new Database();
			con = dbconn.Get_Connection();
			String s2 = "SELECT * FROM employee";
			PreparedStatement ps1 = con.prepareStatement(s2);
			rs = ps1.executeQuery();
			if (rs.next()) {
				n = 1;
			}
			employee = projectManager.GetEmp();
			Gson gson = new Gson();
			emp = gson.toJson(employee);
		} catch (Exception e) {
			System.out.println("Exception Error");
		}

		if (n > 0)
			return emp;
		else
			return "Please Check The Data Base";
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String addEmployee(@FormParam("fnme") String fName, @FormParam("lname") String lName,  //public method
			@FormParam("empid") String eid, @FormParam("email") String email) {
		int n1, n2, n3, n4;
		n1 = fName.length();
		n2 = lName.length();
		n3 = eid.length();
		n4 = email.length();
		String st = null;
		if ((n1 > 0) && (n2 > 0) && (n3 > 0) && (n4 > 0)) {
			try {
				ProjectManager projectManager = new ProjectManager();
				st = projectManager.addemployee(fName, lName, eid, email);
			} catch (Exception e) {
				return e.getMessage();
			}

		}
		return st;
	}

	@Path("/{eid}")
	@DELETE
	public String deleteEmployee(@PathParam("eid") String id) {
		String mp = null;
		ProjectManager projectManager = new ProjectManager();
		final int n1 = 0;
		try {
			mp = projectManager.Deleteemployee(id);
		} catch (Exception e) {
			System.out.println("Exception Error " + e);
			return e.getMessage();
		}
		return mp;
	}

	@Path("/{eid}")
	@GET
	public String singleemployee(@PathParam("eid") String id) throws SQLException {
		String emp = null;
		Connection con = null;
		ResultSet rs = null;
		int n = 0;
		String s1 = "Please Enter A valid Employee id or Employee does't Exit ";
		try {
			ArrayList<Employee> employee = null;
			Database dbcon = new Database();
			con = dbcon.Get_Connection();
			final String s2 = "SELECT * FROM employee WHERE empid=" + id + "";
			PreparedStatement ps1 = con.prepareStatement(s2);
			rs = ps1.executeQuery();
			if (rs.next()) {
				n = 1;
			}
			ProjectManager projectManager = new ProjectManager();
			employee = projectManager.GetSingleEmp(id);
			Gson gson = new Gson();
			emp = gson.toJson(employee);
		} catch (Exception e) {
			System.out.println("Exception Error+" + e);
		}
		if (n == 0)
			return "Please Enter a valid Employee id";
		else if (rs.isFirst())
			return emp;
		else
			
		return "Please Check The Data Base";
	}

	@Path("/{empid}")
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateemployee(@PathParam("empid")final String id, @FormParam("fnme") String fName,
			@FormParam("lname") String lName, @FormParam("email") String email) throws SQLException {

		String emp = null;
		Connection con = null;
		ResultSet rs = null;
		int n1 = fName.length();
		int n2 = lName.length();
		int n3 = email.length();
		int n4 = id.length();
		int n5 = 0;
		if ((n1 > 0) && (n2 > 0) && (n3 > 0) && (n4 > 0)) {
			try {
				ArrayList<Employee> employee = null;
				Database db = new Database();
				con = db.Get_Connection();
				String st = "SELECT * FROM employee WHERE empid=" + id + "";
				PreparedStatement ps1 = con.prepareStatement(st);
				rs = ps1.executeQuery();
				ProjectManager projectManager = new ProjectManager();
				employee = projectManager.updateEmp(id, fName, lName, email);
				Gson gson = new Gson();
				emp = gson.toJson(employee);
				n5 = 1;

				System.out.println(n5);
			} catch (Exception e) {
				System.out.println(e);
			}

		}

		if ((n5 > 0) && (rs.next()))
			return emp;
		else
			return "Please Enter Correct Details and valid Employee id";

	}

}
