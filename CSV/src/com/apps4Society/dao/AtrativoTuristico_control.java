package com.apps4Society.dao;

import com.apps4Society.conf.ConfBanco;
import com.apps4Society.model.AtrativoTuristico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AtrativoTuristico_control {
	
	
	public boolean verificaAtrativoTuristico(AtrativoTuristico at) throws SQLException{
		Connection cx = ConfBanco.getConnection();
		String sql = "SELECT nome,como_chegar FROM atrativos_turisticos";
		PreparedStatement st = (PreparedStatement)cx.prepareStatement(sql);
		ResultSet rx = st.executeQuery();
		while(rx.next()){
			String nome = rx.getString("nome");
			String comochegar = rx.getString("como_chegar");
			if(at.getNome().equals(nome) && at.getComoChegar().equals(comochegar)){
				return true;
			}
		}
		rx.close();
		st.close();
		cx.close();
		return false;
	}
	
	public void addAtratativoTuristico(AtrativoTuristico aTuristico) throws SQLException{
		
		if(verificaAtrativoTuristico(aTuristico)){
			System.out.println("Atrativo turistico ja foi adicionado no banco");
		}else{
			try{
				Connection cx = ConfBanco.getConnection();
				String sql = "INSERT INTO atrativos_turisticos(nome,como_chegar,descricao,info_contato,latitude,longitude,site)" +
						"VALUES (?,?,?,?,?,?,?)";
				PreparedStatement statement = (PreparedStatement)cx.prepareStatement(sql);
				statement.setString(1, aTuristico.getNome());
				statement.setString(2, aTuristico.getComoChegar());
				statement.setString(3, aTuristico.getDescricao());
				statement.setString(4,aTuristico.getInfoContato());
				statement.setDouble(5, aTuristico.getLatitude());
				statement.setDouble(6,	aTuristico.getLongitude());
				statement.setString(7,aTuristico.getSite());
				
				
				statement.execute();
				statement.close();
				cx.close();
				System.err.println("Atratativo Turistico Adicionado!");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	public void deleteAtrativoTuristico(int ID_atratativo) throws SQLException{
		try{
			Connection cx= ConfBanco.getConnection();
			String sql = "DELETE FROM atratativos_turisticos WHERE id = ?";
			PreparedStatement statement =(PreparedStatement)cx.prepareStatement(sql);
			statement.setInt(1,ID_atratativo);
			
			cx.close();
			statement.close();
			System.out.println("Atratativo Turistico Removido");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
