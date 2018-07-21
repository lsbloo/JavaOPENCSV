package com.apps4Society.dao;

import com.apps4Society.conf.ConfBanco;
import com.apps4Society.model.User;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Interf.DataUser;

public class User_control implements DataUser{
	
	

	public void CadaddUser(User user) throws ClassNotFoundException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		// utilizando a classe MD para criar o algoritmo de cript
		// pegando a senha do usuario em byte e utilizando o algoritmo da classe md
		// utilizando a classe Stringbuilder para criar uma Stringhexadecimal 
		// percorrendo cada byte do array de bytes do pass_hash
		// adicionando cada byte transformado no objeto hexString e por fim pegando a String do objeto
		// hexString
		
		String pass_user = user.getPass();
		
		final MessageDigest md = MessageDigest.getInstance("MD5");
		final byte[] pass_hash = md.digest(pass_user.getBytes("UTF-8"));
		StringBuilder hexString = new StringBuilder();
		for(byte bb : pass_hash) {
			hexString.append(String.format("%02X", 0xFF & bb));
		}
		String senhacript = hexString.toString();
		user.setPass(senhacript);
		
		
		if(verificUser(user)) {
			System.out.println("Usuario ja cadastrado!");
		}else {
			String sql = "INSERT INTO usuarios (nome,login,pass,email,codigo) VALUES (?,?,?,?,?)";
			
			
			Connection cx = ConfBanco.getConnection();
		
			PreparedStatement stat = (PreparedStatement)cx.prepareStatement(sql);
			
			stat.setString(1, user.getNome());
			stat.setString(2, user.getLogin());
			stat.setString(3, user.getPass());
			stat.setString(4, user.getEmail());
			stat.setString(5, user.getCodigo());
			
			
			stat.execute();
			stat.close();
			cx.close();
			System.out.println("Usuario cadastrado!");
		}
		
		
	}

	public User getUserInfo(String name) {
		// TODO Auto-generated method stub
		
		return null;
	}

	public void removeUser(String nomeUser, String codigoUser) {
		// TODO Auto-generated method stub
		
	}

	public User searchUser(String nameUser, String codigoUser) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean verificUser(User user) throws ClassNotFoundException, SQLException {
		Connection cx = ConfBanco.getConnection();
		
		String sql = "SELECT login,pass,codigo FROM usuarios";
		PreparedStatement stat = (PreparedStatement)cx.prepareStatement(sql);
		
		ResultSet rx = stat.executeQuery();
		
		while(rx.next()) {
			
			String log = rx.getString("login");
			String pass = rx.getString("pass");
			String codigo = rx.getString("codigo");
			if(user.getLogin().equals(log) && user.getPass().equals(pass) && user.getCodigo().equals(codigo)) {
				return true;
			}
		}
		cx.close();
		rx.close();
		stat.close();
		return false;
	}

	public boolean efetuarLogin(String login, String pass, String codigo) throws ClassNotFoundException, SQLException {
		String cod_p = "49946325";
		Connection cx = ConfBanco.getConnection();
		
		String sql = "SELECT login,pass,codigo FROM usuarios";
	
		PreparedStatement st = (PreparedStatement)cx.prepareStatement(sql);
		ResultSet rx = st.executeQuery();
		while(rx.next()) {
			
			String log = rx.getString("login");
			String pas = rx.getString("pass");
			String cod = rx.getString("codigo");
			
			if(login.equals(log) && pass.equals(pas) && codigo.equals(cod_p)){
				return true;
			}
			
		}
		return false;
	}

}
