package me.koala.enigma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Enigma extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream("/EnigmaKeyboard.fxml"));
        root.getStylesheets().add(getClass().getResource("/keyboard.css").toExternalForm());
        stage.addEventHandler(KeyEvent.KEY_PRESSED, loader.<KeyboardController>getController()::keyPressedListener);
        stage.addEventHandler(KeyEvent.KEY_RELEASED, loader.<KeyboardController>getController()::keyReleasedListener);
        stage.setResizable(false);
        stage.setTitle("Enigma");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
