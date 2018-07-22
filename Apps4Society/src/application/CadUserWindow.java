package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class CadUserWindow extends Application{
	
	
	

	@Override
	public void start(Stage segundajanela) throws Exception {
		// TODO Auto-generated method stub
		segundajanela.setTitle("Cadastro de usuarios");
		Pane cad_user = FXMLLoader.load(getClass().getResource("CadUser.fxml"));
		
		Scene s = new Scene(cad_user,400,300);
		segundajanela.setScene(s);
		segundajanela.setResizable(false);
		segundajanela.show();
		
	}
	

}
