package application;
	
import java.io.IOException;

import apps4Society.controller.UserController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
	private UserController user;
	private CadUserWindow cad;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		user = new UserController();
		cad = new CadUserWindow();
		
		primaryStage.setTitle("Bem vindo ao Apps4Society CSV");
		Pane painel_user = FXMLLoader.load(getClass().getResource("InterUser.fxml"));
		
		
		Scene scene_user = new Scene(painel_user,600,350);
		
		primaryStage.setResizable(false);
		primaryStage.setScene(scene_user);
		
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
