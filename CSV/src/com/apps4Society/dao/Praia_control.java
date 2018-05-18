package com.apps4Society.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.apps4Society.conf.ConfBanco;
import com.apps4Society.model.AtrativoTuristico;
import com.apps4Society.model.Praia;

public class Praia_control {
	public void addPraia(Praia praia) throws SQLException{
		try{
			Connection cx = ConfBanco.getConnection();
			String sql = "INSERT INTO praias(nome,comochegar,descricao,info_contato,latitude,longitude,perigo_tubarao,propia_banho,tipo_orla)" +
					"VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = (PreparedStatement)cx.prepareStatement(sql);
			statement.setString(1, praia.getNome());
			statement.setString(2, praia.getComochegar());
			statement.setString(3, praia.getDescricao());
			statement.setString(4,praia.getInfo_contato());
			statement.setDouble(5, praia.getLatitude());
			statement.setDouble(6,	praia.getLongitude());
			statement.setBoolean(7,praia.getPerigoTubarao());
			statement.setBoolean(8, praia.getPropiaBanho());
			statement.setString(9, praia.getTipoOrla());
			
			
			statement.execute();
			statement.close();
			cx.close();
			System.err.println("Praia Adicionado!");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
