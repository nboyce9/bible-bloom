package com.nboyce.bible_bloom.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public void save(ActionEvent event){
        String thought = journalArea.getText();
        List<String> thoughts = new ArrayList<>();
        thoughts.add(thought);
    }
    public void clear(ActionEvent event){
        journalArea.clear();
    }
}
