package com.nboyce.bible_bloom.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class HomepageController {
    private Stage stage;
    @FXML
    Label homeLabel;
    public void greet(ActionEvent event) throws IOException {
        homeLabel.setText("Hello, World!");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/nboyce/bible_bloom/view/login.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
