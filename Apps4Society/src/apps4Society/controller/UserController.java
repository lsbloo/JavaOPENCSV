package apps4Society.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import apps4Society.dao.User_control;


public class UserController implements Initializable{
	/*
	 * (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 * 
	 * Controler of View User
	 * CadUser
	 * LogINUser
	 */
	@FXML
	private Button entrar;
	
	@FXML 
	private TextField loginf;
	@FXML 
	private PasswordField pass_f;
	@FXML
	private PasswordField cod_f;
	
	private Alert dialogError;

	

	@FXML
	private boolean loginUser(ActionEvent event) throws ClassNotFoundException, SQLException {
		/*
		 * Event of acess User to System. Botton
		 * Verificar a entrada de dados do usuario ( evitar entradas vazias!)
		 * imprimir senha invalida Caixa de texto ou aviso
		 */
		dialogError = new Alert(Alert.AlertType.ERROR);
		
		if(loginf.getText().toString().isEmpty() || pass_f.getText().toString().isEmpty() || cod_f.getText().toString().isEmpty()) {
			dialogError.setTitle("Erro de Login");
			dialogError.setContentText("Preencha os campos corretamente!");
			dialogError.showAndWait();
		}else {
			User_control dt = new User_control();
			boolean saida = dt.efetuarLogin(loginf.getText().toString(),pass_f.getText().toString() , cod_f.getText().toString());
			System.out.println(saida);
			return saida;
		}
		return false;
		
		
		
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
