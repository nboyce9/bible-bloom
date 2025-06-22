package com.nboyce.bible_bloom.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class JournalController {
    private Stage stage;
    private FXMLLoader loader;
    private Scene scene;
    @FXML
    TextArea journalArea;
    public void journalPage() throws IOException {
        loader = new FXMLLoader(getClass().getResource("journal.fxml"));
        scene = new Scene(loader.load());
        stage.show();
    }
//    public void journal(ActionEvent event) throws IOException{
//        loader = new FXMLLoader(getClass().getResource("/com/nboyce/bible_bloom/view/journal.fxml"));
//        scene = new Scene(loader.load());
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    }

    public void clear(ActionEvent event){
        journalArea.clear();
    }
}
