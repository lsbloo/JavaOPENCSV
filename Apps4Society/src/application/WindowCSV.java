package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class WindowCSV extends Application{
	
	

	@Override
	public void start(Stage windowcsv) throws Exception {
		// TODO Auto-generated method stub
		
		Pane tela_csv = FXMLLoader.load(getClass().getResource("Tela.fxml"));
		
		Scene csv_tela = new Scene(tela_csv,600,400);
		
		windowcsv.setTitle("Decodificador CSV");
		windowcsv.setResizable(false);
		windowcsv.setScene(csv_tela);
		windowcsv.show();
	}

}
