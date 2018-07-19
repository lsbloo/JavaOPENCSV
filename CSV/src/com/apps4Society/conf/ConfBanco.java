package com.apps4Society.conf;
import java.sql.*;
public class ConfBanco {
	
	
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		Class.forName("org.postgresql.Driver");
		
		// [e necessario criar uma conexao SSL - com o banco de dados externo
		// arquivos de configuracoes do post-
		// cd data - nano postgresql.conf e nano pg_hba.conf
		// criterios para o SSL alterar os arquivos de configuracoes a cima
		// utilizar o comando opensSL para gerar um certificado e validar
		// alguns arquivos vao ser necessarios tb armazenando a key
		
		String url = "jdbc:postgresql://192.168.31.143:5444/apps4Society";
		
		Connection com = DriverManager.getConnection(url,"postgres","6036236");
		
		
		return com;
	}

}
