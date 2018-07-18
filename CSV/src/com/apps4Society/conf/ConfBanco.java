package com.apps4Society.conf;
import java.sql.*;
public class ConfBanco {
	
	
	
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:postgresql://localhost:5432/apps4Society";
		
		Connection com = DriverManager.getConnection(url,"postgres","admin");
		
		
		return com;
	}

}
