package com.apps4Society.conf;
import java.sql.*;
public class ConfBanco {
	
	
	
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:postgresql://localhost:5432/apps4Society";
		//String usuario="postgres";
		//String passwd="admin";
		//String database="apps4Society";	
		//System.out.println(passwd);
		//System.out.println(usuario);
		//String conexaoUrl = url+";user"+usuario+";password"+passwd+";";
		
		Connection com = DriverManager.getConnection(url,"postgres","admin");
		
		if(com!=null){
			System.out.print("ok");
		}
		return com;
	}

}
