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
    List<BibleBook> books = null;

    public void searchBibleVerse(){
//        bookField.getItems().add("Genesis");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ReadFromJson readFromJson = new ReadFromJson();
        try {
            books = readFromJson.getBooks();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(BibleBook book: books){
            bookField.getItems().add(book.getBook());
            bookField.setOnAction(this::getChapter);
        }

    }
    public void getChapter(ActionEvent event){
        String book = bookField.getValue();
        BibleBook selectedBook = books.stream()
                .filter(b -> b.getBook().equals(book))
                .findFirst().orElse(null);

        int chapterSize = selectedBook.getChapters().size();
        if(selectedBook != null) {
            chapterField.getItems().clear();
            for (int i = 1; i < chapterSize; i++) {
                chapterField.getItems().add(String.valueOf(i));
            }
        }
    }
}
