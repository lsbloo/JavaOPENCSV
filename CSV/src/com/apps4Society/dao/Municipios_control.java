package com.apps4Society.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.apps4Society.conf.ConfBanco;
import com.apps4Society.model.*;
public class Municipios_control {
	
	
	public boolean verificaDados(Municipios city) throws SQLException{
		Connection cx = ConfBanco.getConnection();
		/*
		 * Esse metodo verifica se ja existe dados existentes entre o banco de dados e o CSV
		 * 
		 */
		String sql = "SELECT * FROM municipios";
		PreparedStatement statement =(PreparedStatement)cx.prepareStatement(sql);
		
		ResultSet result = statement.executeQuery();
		while(result.next()){
			String name = result.getString("nome");
			String estado = result.getString("estado");
			if(city.getNome().equals(name) && city.getEstado().equals(estado)){
				// daado ja esta incluso
				return true;
			}
		}
		result.close();
		statement.close();
		cx.close();
		return false;
	}
	
	public void addMunicipio(Municipios municipios) throws ClassNotFoundException, SQLException{
		
		if(verificaDados(municipios)){
			System.out.println("dado ja add");
		}else{
			try{
				Connection cx = ConfBanco.getConnection();
				String sql = "INSERT INTO municipios(cep,area_territorial,estado,latitude,longitude,nome,populacao,site) VALUES(?,?,?,?,?,?,?,?)";
				PreparedStatement statement = (PreparedStatement)cx.prepareStatement(sql);
				statement.setString(1, municipios.getCep());
				statement.setString(2, municipios.getAreaTerritorial());
				statement.setString(3, municipios.getEstado());
				statement.setDouble(4,municipios.getLatitude());
				statement.setDouble(5, municipios.getLongitude());
				statement.setString(6, municipios.getNome());
				statement.setInt(7, municipios.getPopulacao());
				statement.setString(8, municipios.getSite());
				
				statement.execute();
				statement.close();
				cx.close();
				System.err.println("Adicionado!");
			}catch(Exception e){
				e.printStackTrace();
			}
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
