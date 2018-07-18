package com.apps4Society.conf;
import java.sql.*;
public class ConfBanco {
	
	
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		Class.forName("org.postgresql.Driver");
		
		String url = "jdbc:postgresql://192.168.31.143:5432/apps4Society";
		
		Connection com = DriverManager.getConnection(url,"postgres","admin");
		
		return com;
	}

}
