package com.lohith.data.Employee.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	public Connection Get_Connection() throws Exception {
		Connection connection = null;
		try {
			String connectionURL = "jdbc:mysql://localhost:3306/data";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "root", "root");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return connection;

	}

}
