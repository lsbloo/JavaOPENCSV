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
		String sql = "SELECT nome_cidade,estado,latitude,longitude FROM municipios";
		PreparedStatement statement =(PreparedStatement)cx.prepareStatement(sql);
		
		ResultSet result = statement.executeQuery();
		while(result.next()){
			String name = result.getString("nome_cidade");
			String estado = result.getString("estado");
			Double lat = result.getDouble("latitude");
			Double longi = result.getDouble("longitude");
			if(city.getNomecidade().equals(name) && city.getEstado().equals(estado) && city.getLatitude()==lat && city.getLongitude() == longi){
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
			System.err.println("dado ja add");
		}else{
			try{
				Connection cx = ConfBanco.getConnection();
				String sql = "INSERT INTO municipios(date,nome_cidade,descricao,area_territorial,latitude,longitude,estado,populacao,site,informacoes_relevantes,email_responsavel_preenchimento, nome_responsavel_preenchimento, contatos_responsavel_preenchimento,fonte_informacoes) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
				
				PreparedStatement statement = (PreparedStatement)cx.prepareStatement(sql);
				statement.setString(1, municipios.getDate());
				statement.setString(2, municipios.getNomecidade());
				statement.setString(3, municipios.getDescricao());
				statement.setString(4, municipios.getAreaTerritorial());
				statement.setDouble(5, municipios.getLatitude());
				statement.setDouble(6, municipios.getLongitude());
				statement.setString(7, municipios.getEstado());
				statement.setInt(8,municipios.getPopulacao());
				statement.setString(9, municipios.getSite());
				statement.setString(10,municipios.getInformacoesRelevantes());
				statement.setString(11, municipios.getEmail_responsavel());
				statement.setString(12, municipios.getNome_responsavel());
				statement.setString(13, municipios.getContatos_responsavel());
				statement.setString(14, municipios.getFonte_informacoes());
				
				
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
