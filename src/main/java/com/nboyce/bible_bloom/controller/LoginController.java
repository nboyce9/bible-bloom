package com.nboyce.bible_bloom.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private FXMLLoader loader;
    private Scene scene;
    private Stage stage;
    public void login(ActionEvent event) throws IOException {
        loader = new FXMLLoader(getClass().getResource("login.fxml"));
        scene = new Scene(loader.load());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.show();
    }
}
