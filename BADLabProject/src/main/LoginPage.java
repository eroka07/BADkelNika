package main;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginPage extends GridPane{
	private TextField emailField;
    private PasswordField passwordField;

    public LoginPage(Stage stage) {
        Label emailLabel = new Label("Email:");
        emailField = new TextField();

        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();

        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");
        loginButton.setOnAction(e -> handleLogin(stage));
        registerButton.setOnAction(e -> showRegisterPage(stage));

        this.add(emailLabel, 0, 0);
        this.add(emailField, 1, 0);
        this.add(passwordLabel, 0, 1);
        this.add(passwordField, 1, 1);
        this.add(loginButton, 1, 2);
        this.add(registerButton, 1, 3);
    }

    private void handleLogin(Stage stage) {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Email and Password cannot be empty.");
        } else if (email.equals("user@gmail.com") && password.equals("user123")) {
            showUserNavigationBar(stage);
        } else if (email.equals("admin@gmail.com") && password.equals("admin123")) {
            showAdminNavigationBar(stage);
        } else {
            showAlert("Error", "Invalid credentials.");
        }
    }

    private void showUserNavigationBar(Stage stage) {
        UserNavigationBar userNavigationBar = new UserNavigationBar(stage);
        stage.setScene(new Scene(userNavigationBar, 600, 400));
    }

    private void showAdminNavigationBar(Stage stage) {
        AdminNavigationBar adminNavigationBar = new AdminNavigationBar(stage);
        stage.setScene(new Scene(adminNavigationBar, 600, 400));
    }

    private void showRegisterPage(Stage stage) {
        RegisterPage registerPage = new RegisterPage(stage);
        stage.setScene(new Scene(registerPage, 400, 400));
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
