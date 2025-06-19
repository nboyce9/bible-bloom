package com.nboyce.bible_bloom.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class BibleController implements Initializable {
    @FXML
    Label textLabel;
    @FXML
    ChoiceBox<String> bookField, chapterField, verseField;
    private String[] books ={"Genesis", "Exodus", "Leviticus", "Numbers", "Deuteronomy", "Joshua"};

    public void searchBibleVerse(){
//        bookField.getItems().add("Genesis");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bookField.getItems().addAll(books);
        bookField.setOnAction(this::getBook);
    }
    public void getBook(ActionEvent event){
        String book = bookField.getValue();
        System.out.println(book);
    }
}
