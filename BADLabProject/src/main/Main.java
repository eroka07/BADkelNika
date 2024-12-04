package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("KingsHcut");
        showLoginPage(primaryStage);
	}
	
	public void showLoginPage(Stage stage) {
        LoginPage loginPage = new LoginPage(stage);
        stage.setScene(new Scene(loginPage, 400, 300));
        stage.show();
    }

}
