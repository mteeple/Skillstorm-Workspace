package com.skillstorm.jdbc;

// java.sql package
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJdbc {

	public static void main(String[] args) throws SQLException {
		// 1. establish a Connection to the database
		String url = "jdbc:mysql://localhost:3306/chinook";
		String username = "root";
		String password = "root";
		
		// Factory method - new com.mysql.cj.jdbc.ConnectionImpl()
		Connection conn = DriverManager.getConnection(url, username, password); 
		// Connection conn = new com.mysql.cj.jdbc.ConnectionImpl(HostInfo hostInfo)
		
		// 2. issue the SQL statement 
		String userInput = "band'); drop table users; --";
		String sql = "insert into Artist(Name) values ('"+ userInput +"')";
		Statement statement = conn.createStatement();
		statement.executeUpdate(sql); // insert, update, delete, create, alter, drop
		
		System.out.println(statement);
		
		System.out.println("Finished");
		
		// 3. close the connection
		conn.close();
	}
	
}