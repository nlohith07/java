package com.lohith.data.Employee.project;

import java.sql.*;
import java.util.ArrayList;

import javax.ws.rs.FormParam;

import com.lohith.data.Employee.Employee;


public class Project {

	public ArrayList<Employee> GetEmployee(Connection connection) throws SQLException {
		ArrayList<Employee> empData = new ArrayList<Employee>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM employee");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee empobj = new Employee();
				empobj.setFnme(rs.getString("fname"));
				empobj.setLname(rs.getString("lname"));
				empobj.setEmpid(rs.getString("empid"));
				empobj.setEmail(rs.getString("email"));
				empData.add(empobj);
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return empData;
	}

	public String addemp(Connection connection, String fname, String lname, String empid, String email)
			throws Exception {
		try {

			String str = "INSERT INTO `employee`(`fname`,`lname`,`empid`,`email`) VALUES ('" + fname + "','" + lname
					+ "','" + empid + "','" + email + "')";
			PreparedStatement ps = connection.prepareStatement(str);
			int rs = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);
			
		}
		return "One Employee Is Added!!";
	}

	public String deleemp(Connection connection, String str) throws Exception {
		String s2 = "Please Enter A Valid Employee id or Employee does't Exit";
		String s1 = "One Employee Is Sucessfully Deleted ";
		int rs = 0;
		try {
			String s = "DELETE FROM employee WHERE empid=" + str + "";
			System.out.println(s);
			PreparedStatement ps = connection.prepareStatement(s);
			rs = ps.executeUpdate();
			rs=1;
		} catch (SQLException e) {
			if ( e.getMessage().equals("Table 'data.employee' doesn't exist")){
				throw new Exception("Database does not exist.");
			}
		}
		if (rs == 0)
		
		return s2;
		
		else

			return s1;

	}

	public ArrayList<Employee> SingleEmployee(Connection connection, String id) throws Exception {
		ArrayList<Employee> empData = new ArrayList<Employee>();
		ResultSet rs;
		try {
			String s = "SELECT * FROM employee WHERE empid=" + id + "";
			PreparedStatement ps = connection.prepareStatement(s);
			 rs = ps.executeQuery();
			while (rs.next()) {
				Employee empobj = new Employee();
				empobj.setFnme(rs.getString("fname"));
				empobj.setLname(rs.getString("lname"));
				empobj.setEmpid(rs.getString("empid"));
				empobj.setEmail(rs.getString("email"));
				empData.add(empobj);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
			return empData;
	}
		

	public ArrayList<Employee> updateEmployee(Connection connection, String id, String Fname, String Lname,
			String Email) throws Exception {
		ArrayList<Employee> empData = new ArrayList<Employee>();
		try {
			String str = "UPDATE employee SET fname='" + Fname + "', lname='" + Lname + "',email='" + Email
					+ "' WHERE empid='" + id + "'";
			PreparedStatement ps = connection.prepareStatement(str);
			int rs = ps.executeUpdate();
			String st = "SELECT * FROM employee WHERE empid=" + id + "";
			PreparedStatement ps1 = connection.prepareStatement(st);
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				Employee empobj = new Employee();
				empobj.setFnme(rs1.getString("fname"));
				empobj.setLname(rs1.getString("lname"));
				empobj.setEmpid(rs1.getString("empid"));
				empobj.setEmail(rs1.getString("email"));
				empData.add(empobj);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return empData;
	}
}
