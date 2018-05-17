package com.apps4Society.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.apps4Society.conf.ConfBanco;
import com.apps4Society.model.*;
public class Municipios_control {
	
	public void addMunicipio(Municipios municipios) throws ClassNotFoundException, SQLException{
		
		try{
			Connection cx = ConfBanco.getConnection();
			String sql = "INSERT INTO municipios(estado,latitude,longitude,nome,populacao,site) VALUES(?,?,?,?,?,?)";
			PreparedStatement statement = (PreparedStatement)cx.prepareStatement(sql);
			statement.setString(1, municipios.getEstado());
			statement.setDouble(2,municipios.getLatitude());
			statement.setDouble(3, municipios.getLongitude());
			statement.setString(4, municipios.getNome());
			statement.setInt(5, municipios.getPopulacao());
			statement.setString(6, municipios.getSite());
			
			statement.execute();
			statement.close();
			cx.close();
			System.err.println("Adicionado!");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public void removerMunicipio(int ID_municipio) throws ClassNotFoundException, SQLException{
		
		try{
			Connection cx = ConfBanco.getConnection();
			String sql = "DELETE FROM municipios WHERE id= ?";
			PreparedStatement statement = (PreparedStatement)cx.prepareStatement(sql);
			statement.setInt(1, ID_municipio);
			statement.execute();
			
			statement.close();
			cx.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
		

}
