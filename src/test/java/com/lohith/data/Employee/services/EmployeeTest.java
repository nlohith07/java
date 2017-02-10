package com.lohith.data.Employee.services;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.LinkedList;

import org.junit.Ignore;
import org.junit.Test;

import com.google.gson.JsonObject;

public class EmployeeTest {

	// Testing of HTTP Status codes for reaching of resources
	@Test
	public void basicPingTestforget() {
		given().when().get("http://localhost:8080/Employee/").then().statusCode(200);
	}

	@Test
	public void basicPingTestforpost() {                         //public method
		given().when().post("http://localhost:8080/Employee/").then().statusCode(200);
	}

	@Test
	public void basicPingTestforput() {                          //public method
		given().when().put("http://localhost:8080/Employee/").then().statusCode(200);
	}

	@Test                               //public method
	public void basicPingTestfordelete() {
		given().when().put("http://localhost:8080/Employee/").then().statusCode(200);
	}

	@Test
	public void deletetest() {                  //public method
		EmployeeServices emps = new EmployeeServices();
		String msg = emps.deleteEmployee("2011"); // Giving employee id manually
		assertEquals("One Employee Is Sucessfully Deleted ", msg);
	}

	@Test
	public void AddingEmployeeTest() {
		EmployeeServices emps = new EmployeeServices();
		String st = emps.addEmployee("mazar", "chennai", "2014", "mazar@gmai.com");
		assertEquals("One Employee Is Added!!", st);

	}

	@Test
	public void getSingleEmployeeTest() throws SQLException {
		EmployeeServices emps = new EmployeeServices();
		String data = emps.singleemployee("2012");
		System.out.println(data);
		String strJson = "[{\"fnme\":\"vijaya\",\"lname\":\"kumar\",\"empid\":\"2012\",\"email\":\"kumar@gmail.com\"}]";
		assertEquals(strJson, data);

	}
	
	@Test
	public void UpdateEmployeeTest() throws SQLException{
		EmployeeServices emps = new EmployeeServices();
		String data = emps.updateemployee("2013", "barani", "pl", "barani@gmail.com");
		System.out.println(data);
		String strJson = "[{\"fnme\":\"barani\",\"lname\":\"pl\",\"empid\":\"2013\",\"email\":\"barani@gmail.com\"}]";
		assertEquals(strJson, data);

	}

	@Test
	public void getAllEmployeeTest() throws SQLException {        //public method
		EmployeeServices emps = new EmployeeServices();
		String data = emps.employee();
		System.out.println(data);
		String strJson = "[{\"fnme\":\"druva\",\"lname\":\"chennai\",\"empid\":\"2014\",\"email\":\"druva@gmail.com\"},{\"fnme\":\"maruthi\",\"lname\":\"ragi\",\"empid\":\"2010\",\"email\":\"ragi@gmail.com\"},{\"fnme\":\"rakesh\",\"lname\":\"kadamur\",\"empid\":\"2011\",\"email\":\"rakesh@gmail.com\"},{\"fnme\":\"vijaya\",\"lname\":\"kumar\",\"empid\":\"2013\",\"email\":\"kumar@gmail.com\"}]";
		assertEquals(strJson, data);

	}

}
