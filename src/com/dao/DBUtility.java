package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {
	private static Connection connection = null;

	public static Connection getConnection() throws Exception {
		if (connection != null)
			return connection;
		else {
			// Store the database URL in a string
			/*String serverName = "127.0.0.1";
			String portNumber = "1521";
			String sid = "XE";*/
			String dbUrl ="jdbc:mysql://localhost/Country" ;
			Class.forName("com.mysql.jdbc.Driver");

			// set the url, username and password for the databse
			connection = DriverManager.getConnection(dbUrl, "root", "bridgeit");
			return connection;
		}
	}
}