import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apps4Society.view.InterfaceBuscaCSV;
import com.appss4Society.LoaderCSV;
import com.apps4Society.dao.User_control;
import com.apps4Society.model.*;
public class Main {
	/**
	*
	* @author osvaldoairon
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws NoSuchAlgorithmException 
	*/
	public static void main(String[] args) throws IllegalStateException, IOException, ClassNotFoundException, SQLException, NoSuchAlgorithmException{	
		
		User u = new User();
		u.setPass("6036236");
		u.setNome("osvaldo");
		u.setEmail("osvaldo_cavalcanti_filho@hotmail.com");
		u.setCodigo("49946325");
		u.setLogin("lsbloo");
		
		
		User_control dt = new User_control();
		dt.CadaddUser(u);
		boolean saida = dt.efetuarLogin("lsbloo", "121762172626", "49946325");
		System.out.println("Saida: " + saida);
		
		
		
		//new InterfaceBuscaCSV();
		
	}
}
