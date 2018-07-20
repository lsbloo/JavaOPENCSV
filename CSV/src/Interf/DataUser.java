package Interf;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import com.apps4Society.model.User;

public interface DataUser {
	
	public boolean verificUser(User user) throws ClassNotFoundException, SQLException;
	public void CadaddUser(User user) throws ClassNotFoundException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException;
	public User getUserInfo(String name);
	public void removeUser(String nomeUser, String codigoUser);
	public User searchUser(String nameUser , String codigoUser);

}
