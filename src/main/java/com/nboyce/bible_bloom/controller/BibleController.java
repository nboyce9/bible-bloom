package com.nboyce.bible_bloom.controller;

import com.nboyce.bible_bloom.BibleBook;
import com.nboyce.bible_bloom.ReadFromJson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BibleController implements Initializable {
    @FXML
    Label textLabel;
    @FXML
    ChoiceBox<String> bookField, chapterField, verseField;

    public void searchBibleVerse(){
//        bookField.getItems().add("Genesis");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ReadFromJson readFromJson = new ReadFromJson();
        List<BibleBook> books = null;
        try {
            books = readFromJson.getBooks();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(BibleBook book: books){
            bookField.getItems().add(book.getBook());
            bookField.setOnAction(this::getBook);
        }

    }
    public void getBook(ActionEvent event){
        String book = bookField.getValue();
        System.out.println(book);
    }
}
